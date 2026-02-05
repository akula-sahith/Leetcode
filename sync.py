import requests
import os

BASE_URL = "https://leetcode.com/graphql"

HEADERS = {
    "Content-Type": "application/json",
    "Cookie": f"LEETCODE_SESSION={os.environ['LEETCODE_SESSION']}; csrftoken={os.environ['LEETCODE_CSRF_TOKEN']}",
    "X-CSRFToken": os.environ["LEETCODE_CSRF_TOKEN"],
    "Referer": "https://leetcode.com"
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

response = requests.post(BASE_URL, json={"query": QUERY}, headers=HEADERS)
data = response.json()

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
