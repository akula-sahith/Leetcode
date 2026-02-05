import requests
import os
import sys

BASE_URL = "https://leetcode.com/graphql"

USERNAME = os.environ.get("LEETCODE_USERNAME")
if not USERNAME:
    print("❌ LEETCODE_USERNAME not set")
    sys.exit(1)

HEADERS = {
    "Content-Type": "application/json",
    "Referer": "https://leetcode.com",
    "X-CSRFToken": os.environ["LEETCODE_CSRF_TOKEN"],
    "Cookie": (
        f"LEETCODE_SESSION={os.environ['LEETCODE_SESSION']}; "
        f"csrftoken={os.environ['LEETCODE_CSRF_TOKEN']}"
    )
}

# ---------------------------
# 1️⃣ Get recent submissions
# ---------------------------
LIST_QUERY = f"""
query {{
  recentSubmissionList(username: "{USERNAME}") {{
    id
    title
    titleSlug
    lang
    statusDisplay
  }}
}}
"""

list_res = requests.post(
    BASE_URL,
    headers=HEADERS,
    json={"query": LIST_QUERY},
    timeout=15
)

list_data = list_res.json()

if "errors" in list_data:
    print("❌ Error fetching submission list:")
    print(list_data["errors"])
    sys.exit(1)

subs = list_data["data"]["recentSubmissionList"]

# ---------------------------------
# 2️⃣ Fetch code for each submission
# ---------------------------------
CODE_QUERY = """
query submissionDetails($submissionId: Int!) {
  submissionDetails(submissionId: $submissionId) {
    code
  }
}
"""

for sub in subs:
    if sub["statusDisplay"] != "Accepted":
        continue
    if sub["lang"].lower() != "java":
        continue

    variables = {"submissionId": int(sub["id"])}

    code_res = requests.post(
        BASE_URL,
        headers=HEADERS,
        json={"query": CODE_QUERY, "variables": variables},
        timeout=15
    )

    code_data = code_res.json()

    if "errors" in code_data:
        print(f"⚠️ Failed to fetch code for {sub['titleSlug']}")
        continue

    code = code_data["data"]["submissionDetails"]["code"]

    folder = f"Java/{sub['titleSlug']}"
    os.makedirs(folder, exist_ok=True)

    with open(f"{folder}/Solution.java", "w", encoding="utf-8") as f:
        f.write(code)

print("✅ LeetCode sync completed successfully")
