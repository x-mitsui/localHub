--1.string.find��ʹ��
local testStr="HelloLua,HelloWorld"
j,k=string.find(testStr,"Hello")
print(j,k)-->1    5

i = string.find(testStr,"ok")
print(i)

--2.string.match()������ʹ��

m= string.match(testStr,"Hello")--�Ƿ���Ŀ���ַ�������������nil
print(m)

--3.string.sub��ȡ�ַ���ʹ��
--��   1->-1��ʾ��ȡȫ���ַ��� -1->0��ȡ���ַ�����
s=string.sub(testStr,1,1)
print(s)

--4.�滻
n=string.gsub(testStr,"HelloLua","HelloCpp")
print(n)
print(testStr)-- ����ԭ���ַ���

--5.ɾ���ַ���
t=testStr;
l=nil
print(l)
s=string.gsub(testStr,"Lua","")
print(s)