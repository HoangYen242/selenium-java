package tvn.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PalindromeTest {
    @Test
    void tc01(){
        Assert.assertTrue(Basic.isPalindrome("adda"));
    }

    @Test
    void tc02(){
        Assert.assertFalse(Basic.isPalindrome("adfds"));
    }

    @Test
    void tc03(){
        Assert.assertTrue(Basic.isPalindrome("12321"));
    }

}
