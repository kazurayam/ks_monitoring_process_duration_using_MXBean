# Monitoring process using Java MXBean in Katalon Studio

In a topic in Katalon Community forum, Monty_Bagati gave a set of Groovy codes that tells how to monitor the processes invoked in a Katalon Studio project.

- - https://forum.katalon.com/t/the-parallel-execution-of-api-test-within-the-suite-take-much-more-time-than-when-they-are-ran-sequentially/194996/15

I was interested in his work because his work showed me how to utilize `java.lang.management.ManagementFactory` and `java.lang.management.RuntimeMXBean`,
which I am not aware of at all.

So I wanted to learn the technology in a simple example. I read the following tutorial.

- https://kodejava.org/how-do-i-get-the-start-time-of-a-jvm/

then I wrote a simple Groovy code `Test Listeners/JMVMonitor`.

I ran `Test Suites/web-service-tests - All Test Cases`. I got the following output in the console.

```
[0.012s][warning][cds] Archived non-system classes are disabled because the java.system.class.loader property is specified (value = "groovy.lang.GroovyClassLoader"). To use archived non-system classes, this property must not be set
2026-11-10 22:15:36.177 INFO  c.k.k.c.l.logback.LogbackConfigurator    - Logback default configuration initialized from: /Applications/Katalon Studio.app/Contents/Eclipse/configuration/org.eclipse.osgi/166/0/.cp/resources/logback/logback-execution.xml
2026-11-10 22:15:36.179 INFO  c.k.k.c.l.logback.LogbackConfigurator    - Logback custom configuration initialized from: /Users/kazuakiurayama/katalon-workspace/ks_monitoring_process_duration_using_MXBean/Include/config/log.properties
2026-11-10 22:15:36.600 INFO  c.k.katalon.core.main.TestSuiteExecutor  - START Test Suites/web-service-tests - All Test Cases
2026-11-10 22:15:36.645 INFO  c.k.katalon.core.main.TestSuiteExecutor  - userFullName = URAYAMA,kazuaki
2026-11-10 22:15:36.645 INFO  c.k.katalon.core.main.TestSuiteExecutor  - projectName = web-service-tests
2026-11-10 22:15:36.645 INFO  c.k.katalon.core.main.TestSuiteExecutor  - hostName = kazuakiurayama - localhost
2026-11-10 22:15:36.646 INFO  c.k.katalon.core.main.TestSuiteExecutor  - os = Mac OS X 64bit
2026-11-10 22:15:36.646 INFO  c.k.katalon.core.main.TestSuiteExecutor  - hostAddress = 127.0.0.1
2026-11-10 22:15:36.647 INFO  c.k.katalon.core.main.TestSuiteExecutor  - katalonVersion = 11.7.0
[before test suite] Pid: 11935, Start Time Tue Nov 10 22:15:34 JST 2026
2026-11-10 22:15:36.806 INFO  c.k.katalon.core.main.TestCaseExecutor   - --------------------
2026-11-10 22:15:36.806 INFO  c.k.katalon.core.main.TestCaseExecutor   - START Test Cases/Create a new user
2026-11-10 22:15:36.820 INFO  c.k.katalon.core.main.TestCaseExecutor   - age = 25
2026-11-10 22:15:36.821 INFO  c.k.katalon.core.main.TestCaseExecutor   - username = mimi
2026-11-10 22:15:36.821 INFO  c.k.katalon.core.main.TestCaseExecutor   - password = 123456789
2026-11-10 22:15:36.821 INFO  c.k.katalon.core.main.TestCaseExecutor   - avatar = https://www.rd.com/wp-content/uploads/2019/06/lily-of-the-valley-760x506.jpg
2026-11-10 22:15:36.822 INFO  c.k.katalon.core.main.TestCaseExecutor   - gender = MALE
[before test case] Pid: 11935, Start Time Tue Nov 10 22:15:34 JST 2026
2026-11-10 22:15:36.857 DEBUG testcase.Create a new user               - 1: sample.Common.createNewUser(age, username, password, gender, 200)
2026-11-10 22:15:37.834 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /Users/kazuakiurayama/katalon-workspace/ks_monitoring_process_duration_using_MXBean/Reports/20261110_221534/web-service-tests - All Test Cases/20261110_221534/requests/main/POST-a-new-user_0.har
2026-11-10 22:15:37.842 INFO  c.k.k.core.webservice.common.HarLogger   - cURL Command:\ncurl \\n  --location \\n  --request POST \\n  --data '{"age":25,"avatar":null,"gender":"MALE","password":"123456789","username":"mimi"}' \\n  --header 'Content-Type: application/json' \\n  'https://sample-web-service-aut.herokuapp.com/api/users/json'
2026-11-10 22:15:37.928 INFO  c.k.k.core.main.WSVerificationExecutor   - --------------------
2026-11-10 22:15:37.928 INFO  c.k.k.core.main.WSVerificationExecutor   - START Verification
2026-11-10 22:15:37.956 DEBUG testcase.POST a new user                 - 1: request = getInstance().getCurrentRequest()
2026-11-10 22:15:37.957 DEBUG testcase.POST a new user                 - 2: response = getInstance().getCurrentResponse()
2026-11-10 22:15:37.958 DEBUG testcase.POST a new user                 - 3: assert response.getStatusCode() == 200
2026-11-10 22:15:37.961 DEBUG testcase.POST a new user                 - 4: verifyElementPropertyValue(response, "age", 25)
2026-11-10 22:15:37.984 DEBUG testcase.POST a new user                 - 5: verifyElementPropertyValue(response, "username", "mimi")
2026-11-10 22:15:37.993 DEBUG testcase.POST a new user                 - 6: verifyElementPropertyValue(response, "password", "123456789")
2026-11-10 22:15:38.003 DEBUG testcase.POST a new user                 - 7: verifyElementPropertyValue(response, "gender", "MALE")
2026-11-10 22:15:38.012 INFO  c.k.k.core.main.WSVerificationExecutor   - END Verification
2026-11-10 22:15:38.035 INFO  k.k.c.m.CustomKeywordDelegatingMetaClass - sample.Common.createNewUser is PASSED
[after test case] Pid: 11935, Start Time Tue Nov 10 22:15:34 JST 2026
2026-11-10 22:15:38.040 INFO  c.k.katalon.core.main.TestCaseExecutor   - END Test Cases/Create a new user
2026-11-10 22:15:38.050 INFO  c.k.katalon.core.main.TestCaseExecutor   - --------------------
2026-11-10 22:15:38.051 INFO  c.k.katalon.core.main.TestCaseExecutor   - START Test Cases/Find user by ID
2026-11-10 22:15:38.056 INFO  c.k.katalon.core.main.TestCaseExecutor   - age = 25
2026-11-10 22:15:38.057 INFO  c.k.katalon.core.main.TestCaseExecutor   - username = mimi
2026-11-10 22:15:38.057 INFO  c.k.katalon.core.main.TestCaseExecutor   - password = 123456789
2026-11-10 22:15:38.057 INFO  c.k.katalon.core.main.TestCaseExecutor   - gender = MALE
2026-11-10 22:15:38.057 INFO  c.k.katalon.core.main.TestCaseExecutor   - id = 0
[before test case] Pid: 11935, Start Time Tue Nov 10 22:15:34 JST 2026
2026-11-10 22:15:38.166 DEBUG testcase.Find user by ID                 - 1: id = sample.Common.createNewUser(age, username, password, gender, 200)
2026-11-10 22:15:38.365 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /Users/kazuakiurayama/katalon-workspace/ks_monitoring_process_duration_using_MXBean/Reports/20261110_221534/web-service-tests - All Test Cases/20261110_221534/requests/main/POST-a-new-user_1.har
2026-11-10 22:15:38.367 INFO  c.k.k.core.webservice.common.HarLogger   - cURL Command:\ncurl \\n  --location \\n  --request POST \\n  --data '{"age":25,"avatar":null,"gender":"MALE","password":"123456789","username":"mimi"}' \\n  --header 'Content-Type: application/json' \\n  'https://sample-web-service-aut.herokuapp.com/api/users/json'
2026-11-10 22:15:38.421 INFO  c.k.k.core.main.WSVerificationExecutor   - --------------------
2026-11-10 22:15:38.421 INFO  c.k.k.core.main.WSVerificationExecutor   - START Verification
2026-11-10 22:15:38.422 DEBUG testcase.POST a new user                 - 1: request = getInstance().getCurrentRequest()
2026-11-10 22:15:38.422 DEBUG testcase.POST a new user                 - 2: response = getInstance().getCurrentResponse()
2026-11-10 22:15:38.423 DEBUG testcase.POST a new user                 - 3: assert response.getStatusCode() == 200
2026-11-10 22:15:38.423 DEBUG testcase.POST a new user                 - 4: verifyElementPropertyValue(response, "age", 25)
2026-11-10 22:15:38.432 DEBUG testcase.POST a new user                 - 5: verifyElementPropertyValue(response, "username", "mimi")
2026-11-10 22:15:38.441 DEBUG testcase.POST a new user                 - 6: verifyElementPropertyValue(response, "password", "123456789")
2026-11-10 22:15:38.450 DEBUG testcase.POST a new user                 - 7: verifyElementPropertyValue(response, "gender", "MALE")
2026-11-10 22:15:38.458 INFO  c.k.k.core.main.WSVerificationExecutor   - END Verification
2026-11-10 22:15:38.459 INFO  k.k.c.m.CustomKeywordDelegatingMetaClass - sample.Common.createNewUser is PASSED
2026-11-10 22:15:38.460 DEBUG testcase.Find user by ID                 - 2: sample.Common.findUserById(id, age, username, password, gender, 200)
2026-11-10 22:15:38.685 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /Users/kazuakiurayama/katalon-workspace/ks_monitoring_process_duration_using_MXBean/Reports/20261110_221534/web-service-tests - All Test Cases/20261110_221534/requests/main/GET-user-by-id_2.har
2026-11-10 22:15:38.686 INFO  c.k.k.core.webservice.common.HarLogger   - cURL Command:\ncurl \\n  --location \\n  'https://sample-web-service-aut.herokuapp.com/api/users/13'
2026-11-10 22:15:38.741 INFO  c.k.k.core.main.WSVerificationExecutor   - --------------------
2026-11-10 22:15:38.741 INFO  c.k.k.core.main.WSVerificationExecutor   - START Verification
2026-11-10 22:15:38.742 DEBUG testcase.POST a new user                 - 1: request = getInstance().getCurrentRequest()
2026-11-10 22:15:38.743 DEBUG testcase.POST a new user                 - 2: response = getInstance().getCurrentResponse()
2026-11-10 22:15:38.744 DEBUG testcase.POST a new user                 - 3: assert response.getStatusCode() == 200
2026-11-10 22:15:38.745 DEBUG testcase.POST a new user                 - 4: verifyElementPropertyValue(response, "age", 25)
2026-11-10 22:15:38.761 DEBUG testcase.POST a new user                 - 5: verifyElementPropertyValue(response, "username", "mimi")
2026-11-10 22:15:38.775 DEBUG testcase.POST a new user                 - 6: verifyElementPropertyValue(response, "password", "123456789")
2026-11-10 22:15:38.786 DEBUG testcase.POST a new user                 - 7: verifyElementPropertyValue(response, "gender", "MALE")
2026-11-10 22:15:38.797 INFO  c.k.k.core.main.WSVerificationExecutor   - END Verification
2026-11-10 22:15:38.798 INFO  k.k.c.m.CustomKeywordDelegatingMetaClass - sample.Common.findUserById is PASSED
[after test case] Pid: 11935, Start Time Tue Nov 10 22:15:34 JST 2026
2026-11-10 22:15:38.801 INFO  c.k.katalon.core.main.TestCaseExecutor   - END Test Cases/Find user by ID
[after test suite] Pid: 11935, Start Time Tue Nov 10 22:15:34 JST 2026
2026-11-10 22:15:38.824 INFO  c.k.katalon.core.main.TestSuiteExecutor  - --------------------
2026-11-10 22:15:38.824 INFO  c.k.katalon.core.main.TestSuiteExecutor  - END Test Suites/web-service-tests - All Test Cases
```

This tells me that a Test Suite ran in a single JVM instance = OS process with PID=11935.

This sample project is a simple one. No parallelism used. 

Monty_Bagati's tool proved this approach is useful to analyze more complicated "Parallel" project.


