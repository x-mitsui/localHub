--1.string.find的使用
local testStr="HelloLua,HelloWorld"
j,k=string.find(testStr,"Hello")
print(j,k)-->1    5

i = string.find(testStr,"ok")
print(i)

--2.string.match()函数的使用

m= string.match(testStr,"Hello")--是否含有目标字符串，不含返回nil
print(m)

--3.string.sub截取字符的使用
--【   1->-1表示截取全部字符串 -1->0截取空字符串】
s=string.sub(testStr,1,1)
print(s)

--4.替换
n=string.gsub(testStr,"HelloLua","HelloCpp")
print(n)
print(testStr)-- 不改原来字符串

--5.删除字符串
t=testStr;
l=nil
print(l)
s=string.gsub(testStr,"Lua","")
print(s)