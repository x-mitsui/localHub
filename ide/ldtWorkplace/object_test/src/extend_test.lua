Account = { num = 10}

function Account : new ( o )
  o = o or {}
  setmetatable ( o , self )   --�趨oΪAccount������
  self.__index = self
  return o
end

function Account : show ( v )
print (   self.bbb + v )
end

a = Account : new { bb = 6,bbb = 0 }  --�����е���������У�����û�е���������У���Ȼ����Ϊ{b=0}����
a : show ( 1.0 )            --���е��˴��������show�����е�self.bbb��ֵ,���xֵ�o��Ӌ��
print(Account.bbb)
print(Account.bb)
print(Account.b) 
--===============================================================
--===============================================================
--===============================================================
--===============================================================
--===============================================================

Windows = {} -- ����һ�������ռ�
 
-- ����Ĭ��ֵ��
Windows.default = {x = 0, y = 0, width = 100, height = 100, color = {r = 255, g = 255, b = 255}}
 
Windows.mt = {} -- ����Ԫ��
 
-- �������캯��
function Windows.new(o)
     setmetatable(o, Windows.mt)
     return o
end
 
-- ����__indexԪ����
Windows.mt.__index = function ( table,key)
     return Windows.default[key]
end
 
local win = Windows.new({x = 10, y = 10})
print(win.x)               -- >10 ���������Ѿ�ӵ�е�ֵ
print(win.width)          -- >100 ����default���е�ֵ
print(win.color.r)          -- >255 ����default���е�ֵ