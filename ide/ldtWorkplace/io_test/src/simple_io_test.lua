--print默认有换行
io.write("sin(3)=",math.sin(3),"\n")

io.write(string.format("sin(3)=%.4f\n",math.sin(3)))
--io.write("12"..12..1)--错误写法
io.write("12",12,1,"\n")
s=12
f=1
print("12"..s..f)

--读取
--*all 表示读取整个文件
--*line 表示读取第一行
--*number 表示读取第一行的一个数字
--<num> 读取一个不超过<num> 个数的字符的字符串

tt = io.read("*all")

print(tt)

local f =assert(io.open("ff.lua",'r'))
local t =f:read("*all")
print(t)
f:close()