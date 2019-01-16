# GitLab Line Notify
Spring Boot Project for Line Notify with GitLab Webhooks Trigger

## GitLab Webhook Event Support

  * Push
  
  * Tag Push
  
  * Issue
  
  * Merge Request
  
## Getting Started

 * Create Line Notify Service at https://notify-bot.line.me/
 
 * Generate Service Token at https://notify-bot.line.me/my/ (please keep YOUR_LINE_TOKEN for test project)
 
### Development setup
  ```sh
  mvn spring-boot:run -Dskiptests
  ```
### Test GitLab Trigger with Postman

 POST to http://localhost:8080/push 
 
  **Request header** 

  *X-Gitlab-Event* : Push Hook
  
  *Content-Type* : application/json
  
  *Line-Token* : YOUR_LINE_TOKEN
  
  **Request body (raw:JSON)**
  ```
  {
  "object_kind": "tag_push",
  "before": "0000000000000000000000000000000000000000",
  "after": "82b3d5ae55f7080f1e6022629cdb57bfae7cccc7",
  "ref": "refs/tags/v1.0.0",
  "checkout_sha": "82b3d5ae55f7080f1e6022629cdb57bfae7cccc7",
  "user_id": 1,
  "user_name": "John Smith",
  "user_avatar": "https://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=8://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=80",
  "project_id": 1,
  "project":{
    "id": 1,
    "name":"Example",
    "description":"",
    "web_url":"http://example.com/jsmith/example",
    "avatar_url":null,
    "git_ssh_url":"git@example.com:jsmith/example.git",
    "git_http_url":"http://example.com/jsmith/example.git",
    "namespace":"Jsmith",
    "visibility_level":0,
    "path_with_namespace":"jsmith/example",
    "default_branch":"master",
    "homepage":"http://example.com/jsmith/example",
    "url":"git@example.com:jsmith/example.git",
    "ssh_url":"git@example.com:jsmith/example.git",
    "http_url":"http://example.com/jsmith/example.git"
  },
  "repository":{
    "name": "Example",
    "url": "ssh://git@example.com/jsmith/example.git",
    "description": "",
    "homepage": "http://example.com/jsmith/example",
    "git_http_url":"http://example.com/jsmith/example.git",
    "git_ssh_url":"git@example.com:jsmith/example.git",
    "visibility_level":0
  },
  "commits": [],
  "total_commits_count": 0
}
  ```
