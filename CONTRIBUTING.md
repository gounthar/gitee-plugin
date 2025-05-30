# Contributing to the Gitee Plugin

Plugin source code is hosted on [GitHub](https://github.com/jenkinsci/gitee-plugin).
New feature proposals and bug fix proposals should be submitted as [GitHub pull requests](https://help.github.com/articles/creating-a-pull-request).
Your pull request will be evaluated by the [Jenkins job](https://ci.jenkins.io/job/Plugins/job/gitee-plugin/).

Before submitting your change, please assure that you've added tests that verify the change.

## Spotbugs checks

Please don't introduce new spotbugs output.

* `mvn spotbugs:check` analyzes the project using [Spotbugs](https://spotbugs.github.io)
* `mvn spotbugs:gui` displays the spotbugs report using GUI

## Code coverage

Code coverage reporting is available as a maven target.
Please try to improve code coverage with tests when you submit pull requests.

* `mvn -P enable-jacoco clean install jacoco:report` reports code coverage

### Reviewing code coverage

The code coverage report shows methods and lines executed.
The following commands will open the `index.html` file in the browser.

* Windows - `start target\site\jacoco\index.html`
* Linux - `xdg-open target/site/jacoco/index.html`
* Gitpod - `cd target/site/jacoco && python -m http.server 8000`

The file will have a list of package names.
Click on them to find a list of class names.

The lines of the code will be covered in three different colors, red, green, and orange.
Red lines are not covered in the tests.
Green lines are covered with tests.

## Reporting Issues

Report issues in the [Jenkins issue tracker](https://www.jenkins.io/participate/report-issue/redirect/#23941).
Please follow the guidelines in ["How to Report an Issue"](https://www.jenkins.io/participate/report-issue/) when reporting issues.
