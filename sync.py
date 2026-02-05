import requests
import os

BASE_URL = "https://leetcode.com/graphql"
USERNAME = os.environ["LEETCODE_USERNAME"]

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
  recentSubmissionList(username: "sahith_akula_08") {{
    id
    title
    titleSlug
    lang
    statusDisplay
  }}
}}
"""

list_res = requests.post(BASE_URL, headers=HEADERS, json={"query": LIST_QUERY})
list_data = list_res.json()

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
        json={"query": CODE_QUERY, "variables": variables}
    )

    code_data = code_res.json()
    code = code_data["data"]["submissionDetails"]["code"]

    folder = f"Java/{sub['titleSlug']}"
    os.makedirs(folder, exist_ok=True)

    with open(f"{folder}/Solution.java", "w", encoding="utf-8") as f:
        f.write(code)
