1��spring ʹ�� jdbctemplate�������ݿ������
2��������ģʽģ��ֿ���������
	������
	������
	�ֹ���
3�����֪ʶ��
����
����(Transaction)��һ����ָҪ���Ļ����������顣�ڼ������������ָ���ʲ����ܸ������ݿ��и����������һ������ִ�е�Ԫ(unit)���ڼ���������У�����ͨ������ָ���ݿ�����
����
һ�����ݿ�����ͨ�����������ݿ���ж���д��һ���������С����Ĵ��ڰ�������������Ŀ�ģ�
1��Ϊ���ݿ�����ṩ��һ����ʧ���лָ�������״̬�ķ�����ͬʱ�ṩ�����ݿ⼴ʹ���쳣״̬�����ܱ���һ���Եķ����� 
2�������Ӧ�ó����ڲ����������ݿ�ʱ����������ЩӦ�ó���֮���ṩһ�����뷽�����Է�ֹ�˴˵Ĳ���������š�

��һ�������ύ����DBMS�����ݿ����ϵͳ������DBMS��Ҫȷ���������е����в������ɹ���������������ñ��������ݿ��У�����������еĲ���û�гɹ���ɣ��������е����в�������Ҫ���ع����ص�����ִ��ǰ��״̬��Ҫôȫִ�У�Ҫôȫ����ִ�У�;ͬʱ������������ݿ�������������ִ����Ӱ�죬���е����񶼺����ڶ��������С�

������ʵ����£�ʧ�ܵķ��պܸߡ���һ�����ݿ������ִ�й����У��п��ܻ������������ʧ�ܡ����ݿ�ϵͳ/����ϵͳʧ�ܣ������Ǵ洢����ʧ�ܵ�����������ҪDBMS��һ��ִ��ʧ�ܵ�����ִ�лָ��������������ݿ�״̬�ָ���һ��״̬�����ݵ�һ���Եõ���֤��״̬����Ϊ��ʵ�ֽ����ݿ�״̬�ָ���һ��״̬�Ĺ��ܣ�DBMSͨ����Ҫά��������־��׷������������Ӱ�����ݿ����ݵĲ�����
MySQL InnoDB����ĸ��뼶�����ļ���Ĭ���ǡ����ظ�������REPEATABLE READ����

����
��������Ķ����ݿ�Ĳ������ж������ݿ���������Ӧ�þ���4�����ԣ�ԭ���ԡ�һ���ԡ������ԡ��־��ԡ����ĸ�����ͨ����ΪACID����

ԭ���ԣ�Atomicity����������Ϊһ�����屻ִ�У����������еĶ����ݿ�Ĳ���Ҫôȫ����ִ�У�Ҫô����ִ�С� 
һ���ԣ�Consistency��������Ӧȷ�����ݿ��״̬��һ��һ��״̬ת��Ϊ��һ��һ��״̬��һ��״̬�ĺ��������ݿ��е�����Ӧ����������Լ���� 
�����ԣ�Isolation����������񲢷�ִ��ʱ��һ�������ִ�в�ӦӰ�����������ִ�С� 
�־��ԣ�Durability����һ������һ���ύ���������ݿ���޸�Ӧ�����ñ��������ݿ��С�

����

��һ�����õġ�A�˻���B�˺Ż�Ǯ����������˵�����ͨ�����ݿ�����֤���ݵ�׼ȷ�Ժ������ԡ���Ϥ��ϵ�����ݿ�����Ķ�֪�����ʺ�A���ʺ�B��Ҫ6��������

1����A�˺��а�����������500���� 
2����A�˺�������������500-100���� 
3���ѽ��д��A�˺��У�400���� 
4����B�˺��а�����������500���� 
5����B�˺����ӷ�������500+100���� 
6���ѽ��д��B�˺��У�600����

ԭ���ԣ�
��֤1-6���й���Ҫô��ִ�У�Ҫô����ִ�С�һ����ִ��ĳһ����Ĺ����з������⣬����Ҫִ�лع������� ����ִ�е����岽��ʱ��B�˻�ͻȻ�����ã����类ע��������ô֮ǰ�����в�����Ӧ�ûع���ִ������֮ǰ��״̬��

һ����
��ת��֮ǰ��A��B���˻��й���500+500=1000ԪǮ����ת��֮��A��B���˻��й���400+600=1000Ԫ��Ҳ����˵�����ݵ�״̬��ִ�и��������֮���һ��״̬�ı䵽������һ��״̬��ͬʱһ���Ի��ܱ�֤�˻������ɸ����ȡ�

������
��A��Bת�˵����������У�ֻҪ����û���ύ��commit������ѯA�˻���B�˻���ʱ�������˻������Ǯ�������������б仯�� 
�����A��Bת�˵�ͬʱ��������һ������ִ����C��Bת�˵Ĳ�������ô���������񶼽�����ʱ��B�˻������ǮӦ����Aת��B��Ǯ����Cת��B��Ǯ�ټ����Լ�ԭ�е�Ǯ��

�־���
һ��ת�˳ɹ��������ύ���������˻��������Ǯ�ͻ���ķ����仯���������д�����ݿ����־û����棩��
�����ԭ������һ����ȱһ���ɡ�



δ�ύ����READ UNCOMMITTED������һ�������޸������ݣ�����δ�ύ�����������е�SELECT�������Щδ���ύ�����ݣ��������
�ύ����READ COMMITTED�����������ȡ���������µ����ݣ����������ύ��ģ��������ǣ���ͬһ�������ǰ��������ͬ��SELECT�������ͬ�Ľ�������ظ�������
���ظ�����REPEATABLE READ������ͬһ�������SELECT�Ľ��������ʼʱʱ����״̬����ˣ�ͬ����SELECT���������Ľ������һ�µġ����ǣ����лö������Ժ���ͣ���
���л���SERIALIZABLE��������������ʽ��ȡ�����������Ա�֤��ͬ�����Ļ��⡣
�ĸ���������ǿ��ÿ��������һ�����⡣

��������������⡣��һ�������޸������ݣ�����δ�ύ�����������е�SELECT�������Щδ���ύ�����ݡ�
���ظ��������������󣬻�������ͬһ������ִ�й����У�����һ�������ύ�������ݣ���˱������Ⱥ����ζ��������ݽ���᲻һ�¡�
�ö�������˲��ظ�������֤��ͬһ���������ѯ�Ľ����������ʼ���ҵ�һ�β�ѯʱ��״̬��һ���ԣ������ǣ������һ������ͬʱ�ύ�������ݣ���Ȼ�������ٴΰ�����ͬ���������һ�õ���ͬ�Ľ���������Ǳ�����ָ������ʱ(���˺������ʾ��ͻ�֪��)���ͻᡰ����ġ���������Щ�����ݣ�ò��֮ǰ�����������ǡ���Ӱ��һ���Ļþ���