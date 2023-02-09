<h2>JDBC</h2> 
Java ile bir veritabanına (Mysql,Oracle, PostGreSQL gibi) erişmek ve
işlemler yapmak için program ve veritabanı
arasında köprü görevi görür.<br>
JDBC, herhangi bir veritabanına
bağlanarak; SQL komutları ile verilere
ulaşabileceğimiz bir yapıdır.<br> Kullanılan
veritabanına göre bağlantı çeşidini
değiştirmeniz yeterli olur.<br>

<h5>MySQL: com.mysql.jdbc.Driver</h5>
<h5>Oracle SQL: oracle.cj.jdbc.driver.OracleDriver</h5>
<h5>PostgreSQL: org.postgresql.Driver</h5>
<h5>Microsoft SQL: com.microsoft.sqlserver.jdbc.SQLServerDriver</h5>
<h5>SQLite: org.sqlite.JDBC</h5>
<h4>Driver</h4>
Bu arayüz veritabanı sunucusu ile olan iletişimi
idare eder.<br> Genellikle bu nesneyi yöneten DriverManager
nesnesi üzerinden erişim yapılır.<br>
Class.forName("com.mysql.cj.jdbc.Driver");<br>

<h4>Connection</h4> 
Bu arayüz, bir veritabanı ile iletişim kurmak
için tüm yöntemleri içerir. Connection nesnesi iletişim
bağlamını temsil eder, yani veritabanıyla yapılan tüm
iletişim yalnızca bağlantı nesnesi aracılığıyla yapılır.<br>
<h4>DriverManager</h4> 
Bu sınıf, veritabanı sürücülerinin bir
listesini yönetir. Java uygulamasından gelen bağlantı
istekleri ile uygun veritabanı sürücüsünü eşleştirir ve
bağlantı oluşturur.<br>
Connection con = DriverManager.getConnection( );<br>
Statement: Bu arayüz ile SQL ifadeleri veritabanına
iletilir ve çalıştırılır.<br>
Statement st = con.createStatement();<br>

<h4>ResultSet</h4>
JDBC kullanarak veri çekme işlemi
sonrasında veri listelemek için ResultSet sınıfı kullanılır.<br>
SQL sorgusu çalıştırıldıktan sonra veritabanından alınan
verileri saklar. Verilerin arasında gitmemizi sağlar.<br>
ResultSet veri = st.executeQuery("select * from ogrenciler");<br>
Veriler üzerinde dolaşmak için next, first, last, previous,
absolute gibi metotlara sahiptir.<br>
<h4>SQL Exception</h4>
Bu sınıf, bir veritabanı uygulamasında
meydana gelen hataları yönetir.<br>
public static void main(String[] args) throws SQLException<br>

<h4>ResultSetMetaData</h4>
Bu arayüzü kullanarak, ResultSet hakkında daha
fazla bilgi alabiliriz. Her ResultSet nesnesi, bir ResultSetMetaData
nesnesiyle ilişkilendirilir. Bu nesne, sütunun veri türü, sütun adı, sütun
sayısı, tablo adı, şema adı gibi sütun özelliklerinin ayrıntılarına sahip
olacaktır. ResultSet'in, getMetaData () yöntemini kullanarak
ResultSetMetaData nesnesini alabiliriz.<br>
ResultSet rs = ps.executeQuery();<br>
ResultSetMetaData rsmd = rs.getMetaData();<br>

<h4>PreparedStatement</h4>
Yazdığımız herhangi bir SQL sorgusunu
Statement durumunda çalıştırdığımızda; bu sorgu her
çalıştırıldığında veri tabanının belleğinde bu sorgunun bir örneği
saklanır. Bu sorgunun binlerce kere çalıştırıldığını düşünürsek bu
durum veritabanı performansını düşürür veya bağlantı kopmaları
yaşanabilir.<br>
Bu durumda PreparedStatement kullanmak faydalı olabilir.
Herhangi bir SQL sorgusunu PreparedStatement durumunda
çalıştırdığımızda; veri tabanında bu sorgusunun sadece bir kere
örneği saklanır ve bin kere de çalıştırsak bu sorgunun veri
tabanının belleğinde sadece bir örneği tutulur. Böylece
PreparedStatement daha performanslı olur.<br>

<h4>boolean execute(String SQL)</h4>
Bir ResultSet nesnesi alınabiliyorsa, true boolean
değerini döndürür; aksi halde false döndürür. SQL DDL deyimlerini yürütmek için veya
gerçekten dinamik SQL kullanmanız gerektiğinde bu yöntemi kullanın.<br>

<h4>int executeUpdate(String SQL)</h4>
SQL ifadesinin yürütülmesinden etkilenen satır sayısını
döndürür. Birkaç satırın etkilenmesini beklediğiniz SQL deyimlerini yürütmek için bu
yöntemi kullanın,<br>
örneğin, bir INSERT, UPDATE veya DELETE ifadesi.<br>

<h4>ResultSet executeQuery(String SQL)</h4>
Bir ResultSet nesnesi döndürür. Bir SELECT
deyiminde olduğu gibi, bir sonuç kümesi almak için bu yöntemi kullanın.<br>
