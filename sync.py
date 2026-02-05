import requests
import os
import json

BASE_URL = "https://leetcode.com/graphql"

HEADERS = {
    "Content-Type": "application/json",
    "Referer": "https://leetcode.com",
    "X-CSRFToken": os.environ["LEETCODE_CSRF_TOKEN"],
    "Cookie": (
        f"LEETCODE_SESSION={os.environ['LEETCODE_SESSION']}; "
        f"csrftoken={os.environ['LEETCODE_CSRF_TOKEN']}"
    )
}

QUERY = """
query recentSubmissions {
  recentSubmissionList(username: null) {
    title
    titleSlug
    lang
    statusDisplay
    code
  }
}
"""

response = requests.post(
    BASE_URL,
    headers=HEADERS,
    json={"query": QUERY}
)

print("Status Code:", response.status_code)
print("Raw Response:")
print(response.text)

data = response.json()

# 🔒 SAFETY CHECK
if "data" not in data:
    print("❌ No data key found. Full response:")
    print(json.dumps(data, indent=2))
    exit(1)

subs = data["data"]["recentSubmissionList"]

for sub in subs:
    if sub["statusDisplay"] != "Accepted":
        continue
    if sub["lang"].lower() != "java":
        continue

    folder = f"Java/{sub['titleSlug']}"
    os.makedirs(folder, exist_ok=True)

    with open(f"{folder}/Solution.java", "w", encoding="utf-8") as f:
        f.write(sub["code"])
