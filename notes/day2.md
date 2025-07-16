# Day 2:

## Class: 
- Properties (static) and [methods (dynamic) include constructor].
## Constructor:
- Là 1 phương thức khởi tạo, trùng tên class, không trả về dữ liệu.
## Object: 
- Tạo ra từ 1 class.
## Test case vs test scenario?
- Create a test case for login form:
## adHoc vs Exploratory Testing?

## TestNG:
- Import to pom.xml file
- Create unit test for vowels, palindrome function
@Test annotation
Assert: compare expected vs actual
## What is Testing?
- Test = actions + verifications (compare actual của action đó trả về và cái mình mong đợi)

## Array: find max, min element
## Java8 stream
- Sort: naturalOrder, reverseOrder
- Elements greater than 0
- Filter
- Max, min
- collect() return Collection.class

## Exercise:
1. Create fractions class
tu - mau
* Check denominator not equal to 0
class Fraction {
    int tu;
    int mau;
    public Fraction (int tu, int mau) {
        if(mau.equal(0)) {
            throw new IllegalArgumentException("Mau should be different with 0!");
        }
        this.tu = tu; //this đại diện cho class Fraction
        this.mau = mau;
    }
}
* Create a function to sum two fractions
1/2+1/3 = (1*3+1*2)/(2*3) = 5/6
* Create a function to compare two fractions
- a>b, a<b, a=b
- 1/2 vs 1/3 ==> 3/6 vs 2/6 ==> 3 vs 2 
2. Palindrome
3. Find max, min element