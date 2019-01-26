$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("tags_example.feature");
formatter.feature({
  "line": 2,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.before({
  "duration": 16544138,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Regression"
    },
    {
      "line": 4,
      "name": "@E2E"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User Navigate to LogIn Page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User should be able to enter username",
  "rows": [
    {
      "cells": [
        "Username"
      ],
      "line": 9
    },
    {
      "cells": [
        "testuser_1"
      ],
      "line": 10
    },
    {
      "cells": [
        "testuser_2"
      ],
      "line": 11
    },
    {
      "cells": [
        "testuser_3"
      ],
      "line": 12
    },
    {
      "cells": [
        "testuser_4"
      ],
      "line": 13
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "able to enter password",
  "rows": [
    {
      "cells": [
        "Password"
      ],
      "line": 15
    },
    {
      "cells": [
        "Test@153"
      ],
      "line": 16
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "TagsExample.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 40048698986,
  "status": "passed"
});
formatter.match({
  "location": "TagsExample.user_Navigate_to_LogIn_Page()"
});
formatter.result({
  "duration": 23132393,
  "status": "passed"
});
formatter.match({
  "location": "TagsExample.user_should_be_able_to_enter_username(DataTable)"
});
formatter.result({
  "duration": 523022683,
  "status": "passed"
});
formatter.match({
  "location": "TagsExample.able_to_enter_password(DataTable)"
});
formatter.result({
  "duration": 126278835,
  "status": "passed"
});
formatter.after({
  "duration": 57246,
  "status": "passed"
});
});