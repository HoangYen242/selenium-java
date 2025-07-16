package todo;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TodoMVCPage;

public class TodoTest extends BaseTest {
    TodoMVCPage todoMVCPage;

    @Parameters({"browser"})
    @BeforeClass
    void setUp(String browser) {
        Browser.launch(browser);
        todoMVCPage = new TodoMVCPage();
        todoMVCPage.open();
    }

    @BeforeMethod
    void selectAllTaskView(){
        todoMVCPage.selectAllTaskView();
    }

    @Test
    void createNewTodoSuccessfully() {
        todoMVCPage.createNewTask("task 1");
        Assert.assertEquals(todoMVCPage.getLatestTaskName(), "task 1");
    }

    @Test
    void markCompleteATask() {
        todoMVCPage.createNewTask("task 1");
        todoMVCPage.markComplete("task 1");
        todoMVCPage.selectCompletedTaskView();
        Assert.assertEquals(todoMVCPage.getLatestTaskName(), "task 1");
    }

    @Test
    void deleteATaskSuccessfully() {
        todoMVCPage.createNewTask("task 1");

        int beforeDelete = todoMVCPage.getItemsLeft();
        todoMVCPage.delete("task 1");
        int afterDelete = todoMVCPage.getItemsLeft();

        Assert.assertEquals(beforeDelete - afterDelete, 1);
    }

    @Test
    void updateTaskNameSuccessfully() {
        todoMVCPage.createNewTask("task 1");
        todoMVCPage.updateName("task 1", "task 2");

        Assert.assertTrue(todoMVCPage.isTaskNameDisplay("task 2"));
    }


}
