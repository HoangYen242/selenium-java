package tvn.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VowelsTest {
    @Test
    void aIsVowels() {
        Assert.assertTrue(Basic.isVowels("a"));
    }

    @Test
    void AIsVowels() {
        Assert.assertTrue(Basic.isVowels("A"));
    }

    @Test
    void uIsVowels() {
        Assert.assertTrue(Basic.isVowels("u"));
    }

    @Test
    void UIsVowels() {
        Assert.assertTrue(Basic.isVowels("U"));
    }

    @Test
    void eIsVowels() {
        Assert.assertTrue(Basic.isVowels("e"));
    }

    @Test
    void EIsVowels() {
        Assert.assertTrue(Basic.isVowels("E"));
    }

    @Test
    void oIsVowels() {
        Assert.assertTrue(Basic.isVowels("o"));
    }

    @Test
    void OIsVowels() {
        Assert.assertTrue(Basic.isVowels("O"));
    }

    @Test
    void iIsVowels() {
        Assert.assertTrue(Basic.isVowels("i"));
    }

    @Test
    void IIsVowels() {
        Assert.assertTrue(Basic.isVowels("I"));
    }

    @Test
    void bIsNotVowels() {
        Assert.assertFalse(Basic.isVowels("b"));
    }

    @Test
    void numberIsNotVowels() {
        Assert.assertFalse(Basic.isVowels("2"));
    }

    @Test
    void specialCharacterIsNotVowels() {
        Assert.assertFalse(Basic.isVowels("@"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Please input a single letter only!")
    void doubleLetterIsNotVowels() {
        Assert.assertFalse(Basic.isVowels("aa"));
    }

}
