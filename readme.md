Selenium Java Basic
-----------


##  📦 Setting Up
✅ Requirements:
- Java JDK **11**
- Maven 
- Intellij IDEA
- Chrome/Edge driver (if not already installed)

✅ Setting Steps:
1. Clone repository:
```bash
git clone https://github.com/HoangYen242/selenium-java.git
```
2. Open the project with Intellij IDEA.
3. Ensure the **pom.xml** file has all **dependencies** loaded.

## 🚀 How to run
🖥️ Run test on local:
- With test plan ``todomvc-testplan.xml``:
```bash
mvn test -Dtest.suite=todomvc-testplan.xml
```
- With test plan ``bmi-testplan.xml``
```bash
mvn test -Dtest.suite=bmi-testplan.xml
```
- Check the html report at [surefire-report](target/surefire-reports/index.html)

📋 When pushing code on GitHub, workflow CI will also run automatically according to ``.github/workflows/mvn.yml``.

## ➕ How to add more test
To add a new test case to the project:

1️⃣ Create a new test class:
- Go to ``src/test/java/any-package/`` folder
- Create a new class, example: ``MyNewFeatureTest.java``

2️⃣ Write test method:
- In the new file, add one or more methods annotated ``@Test``, example:
```
package testcase;

import org.testng.annotations.Test;

public class MyNewFeatureTest {
    @Test
    void tc01() {
    }
}
```
3️⃣ (If yes) Add Page Object or common method:
- If the test need to operations on the new page or the new action should create more class in:

``src/test/java/page/ (Page Object)``

``src/test/java/common/ (Helper methods)``

4️⃣ Add to test plan:
- Open ``todomvc-testplan.xml`` file (hoặc file testplan tương ứng)
- Add the new class into ``<classes>``:
```
<classes>
    <class name="testcase.MyNewFeatureTest"/>
</classes>
```
5️⃣ Run test:
- Use Maven/cmd:

``your-path>mvn clean test -Dtest.suite=todomvc-testplan.xml``
## 🗂️ Project structure
```selenium-java/
selenium-java/
├── src/
│   ├── main/                  # contains the source code of the software
│   └── test/
│       ├── java/
│       │   ├── common/        # contains funtions and util (Browser, WaitUtils,…)
│       │   ├── page/          # Page Object Model (POM)
│       └── resources/
│           └── testplan/      # chứa các file testplan XML (TestNG suites)
├── .github/
│   └── workflows/
│       └── mvn.yml            # workflow GitHub Actions to run CI
├── pom.xml                    # Maven build file
└── readme.md                  # this file
```
## 📄 For more details, please refer to the comments in the source code.




