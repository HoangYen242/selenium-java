# Day 1: Java Basic

## Setup Java JDK + Maven
## Create new Maven Project with Intellij 
## Variables
- Scope: Class or method
## Exercise:
1. Viết 1 chương trình kiểm tra 1 chữ cái nhập vào. Có phải là nguyên âm, phụ âm hay không?
Phân tích:
- Như thế nào là 1 nguyên âm: 'u e o a i'
- Như thế nào là 1 phụ âm: exclude 'u e o a i'
- Gỉa sử nhập 'a' -> true --> boolean
- Gỉa sử nhập 'b' -> false --> boolean
- checkNguyenAm (String letter)
- Làm sao kiểm tra 1 ký tự thuộc 'ueoai'
- Chấp nhận chữ viết hoa và viết thường
- Nhập số, ký tự đặc biệt -> false
- Nhập lớn hơn 1 ký tự -> exception
- Nhập nhỏ hơn 1 ký tự -> exception
2. Kiểm tra 1 chuỗi ký tự có thỏa mãn PW policy hay không?
- Chứa ký tự đặc biệt
- Chứa số
- Chứa ký tự in hoa
- Chứa ký tự in thường
- Ít nhất 8 ký tự
- Không có khoảng trắng
Phân tích:
- AND 6 conditions
- checkPasswordPolicy (String password)
- Làm sao kiểm tra 1 chuỗi chứa ký tự đặc biệt?
- Làm sao kiểm tra 1 chuỗi chứa ký tự số?
  - Regex -> regular expression