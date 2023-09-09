package com.giftforzhangjun;

import com.giftforzhangjun.tableModel.BiologicalDirectory;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Link {
    /**
     * URL地址
     */
    private static final String URL = "jdbc:mysql://192.168.56.10:3306/zhangjun_datebase?useSSL=false";
    /**
     * 登录数据库服务器的账号
     */
    private static final String USER = "root";
    /**
     * 登录数据库服务器的密码
     */
    private static final String PASSWORD = "123456";
    
    
    /**
     * 返回数据库连接对象
     *
     * @return
     */
    public static Connection getConn() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 关闭资源
     *
     * @param rs
     * @param stat
     * @param conn
     */
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 封装通用的更新操作（即通过该方法实现对弈任意数据表的insert，update，delete操作）
     *
     * @return 执行结果
     */
    public static boolean exeUpdate(String sql, Object... params) {
        // 获取连接对象
        Connection conn = getConn();
        PreparedStatement ps = null;
        try {
            // 获取预编译对象
            ps = conn.prepareStatement(sql);
            // 执行参数赋值操作
            if (Objects.nonNull(params)) {
                // 循环将所有的参数赋值
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            // 执行更新
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            close(null, ps, conn);
        }
        return false;
    }
    
    //        --------------------------------------------------------------------
    // 注册账号
    public static boolean rigister(String name, String code, String sex) throws Exception {
//        判断账号是否存在
        String sql = "select * from rigister where name=?and code=?";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, code);
        ResultSet rs = pstmt.executeQuery();
        if (!rs.next()) {  // 如果不存在
            sql = "insert into rigister(name,code,sex) values (?,?,?)";
            System.out.println("注册成功");
            return exeUpdate(sql, name, code, sex);
        } else {      // 存在
            System.out.println("===以被注册===");
            return false;
        }
    }
    
    
    /**
     * @Description:  新增【生物名录表】的数据库操作
     * @Author: 冲动火龙果
     * @Date: 2023/9/9 22:28
     * @param biologicalDirectory:
     * @return: boolean
     **/
    public static boolean saveBiologicalDirectory(BiologicalDirectory biologicalDirectory) throws Exception {
        String kingdomCn = biologicalDirectory.getKingdomCn();
        String kingdomLatin = biologicalDirectory.getKingdomLatin();
        String phylumCn = biologicalDirectory.getPhylumCn();
        String phylumLatin = biologicalDirectory.getPhylumLatin();
        String classCn = biologicalDirectory.getClassCn();
        String classLatin = biologicalDirectory.getClassLatin();
        String orderCn = biologicalDirectory.getOrderCn();
        String orderLatin = biologicalDirectory.getOrderLatin();
        String familyCn = biologicalDirectory.getFamilyCn();
        String familyLatin = biologicalDirectory.getFamilyLatin();
        String genusCn = biologicalDirectory.getGenusCn();
        String genusLatin = biologicalDirectory.getGenusLatin();
        String speciesCn = biologicalDirectory.getSpeciesCn();
        String speciesLatin = biologicalDirectory.getSpeciesLatin();
        String auditor = biologicalDirectory.getAuditor();
        String directoryVersion = biologicalDirectory.getDirectoryVersion();
        
        // 数据插入的sql
        String sqlStr = "INSERT INTO biological_directory (Kingdom_cn, Kingdom_latin, Phylum_cn, Phylum_latin, Class_cn, Class_latin, Order_cn, Order_latin, Family_cn, Family_latin, Genus_cn, Genus_latin, Species_cn, Species_latin, auditor, directory_version) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return exeUpdate(sqlStr, kingdomCn,kingdomLatin,phylumCn,phylumLatin,classCn,classLatin,orderCn,orderLatin,familyCn,familyLatin,genusCn,genusLatin,speciesCn,speciesLatin,auditor,directoryVersion);
    }
    
    
    // 添加学生账号
    public static boolean rigister(String name, String code, String sex, String id) throws Exception {
//        判断账号是否存在
        String sql1 = "select * from rigister where id=?";
        String sql2 = "select * from rigister where id=?";
        PreparedStatement pstmt = getConn().prepareStatement(sql1);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (!rs.next()) {  // 如果不存在
            sql1 = "insert into rigister(name,code,sex,id) values (?,?,?,?)";
            System.out.println("注册成功");
            return exeUpdate(sql1, name, code, sex, id);
        } else {      // 存在
            System.out.println("===以被注册===");
            return false;
        }
    }
    
    // 添加教师账号
    public static boolean rigister1(String compellation, String code, String sex, String id, String number, String age, String graduate, String salary, String phone) throws Exception {
//        判断账号是否存在
        String sql1 = "select * from teacher where id=?";
        PreparedStatement pstmt = getConn().prepareStatement(sql1);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (!rs.next()) {  // 如果不存在
            sql1 = "insert into teacher(compellation,code,sex,id,number,age,salary,phone,graduate) values (?,?,?,?,?,?,?,?,?)";
            System.out.println("注册成功");
            return exeUpdate(sql1, compellation, code, sex, id, number, age, salary, phone, graduate);
        } else {      // 存在
            System.out.println("===以被注册===");
            return false;
        }
    }
    // 添加账号

//    public static boolean append(String id, String chinese, String mathematics, String english, String chemistry, String history, String number) throws Exception {
//        String sql = "select * from grade where id=?";
//        PreparedStatement pstmt = getConn().prepareStatement(sql);
//        pstmt.setString(1, id);
//        ResultSet rs = pstmt.executeQuery();
//        if (!rs.next()) {  //如果不存在
//            sql = "insert into grade(chinese,mathematics,english,chemistry,history,number) values (?,?,?,?,?,?)";
//            System.out.println("注册成功");
//            return exeUpdate(sql, chinese, mathematics, english, chemistry, history, number);
//        } else {      //存在
//            System.out.println("===请注册===");
//            return false;
//        }
//    }
    
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// 检验学生的密码和账号
    public static boolean pupil(String name, String code, Stage stage) throws Exception {
        // 防止SQL注入
        String sql = "select * from rigister where name=?and code=?";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, code);
        ResultSet rs = pstmt.executeQuery();
        if (!rs.next()) {
            
            ZhangJunMain.tips("账号不存在", stage);
            System.out.println("账号不存在，请注册");
            return false;
        } else {
            System.out.println("登录成功");
            return true;
        }
    }
    
    //        --------------------------------------------------------------------
    // 检验教师的密码和账号
    public static boolean login(String name, String code, Stage stage) throws Exception {
        // 防止SQL注入
        String sql = "select * from teacher where compellation=? and code=?";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, code);
        ResultSet rs = pstmt.executeQuery();
        
        if (!rs.next()) {
            System.out.println("账号不存在，请注册");
            ZhangJunMain.tips("账号不存在", stage);
            return false;
        } else {
            ZhangJunMain.normalStage();
            System.out.println("登录成功");
            return false;
        }
    }
    
    
    //    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//      学生查询信息
    public static void score(Student student, String name, String code) throws Exception {
        String sql = "select * from rigister  where name=? and code=?";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, code);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            student.setC0(rs.getString("id"));
            student.setC1(rs.getString("name"));
            student.setC2(rs.getString("code"));
            student.setC3(rs.getString("sex"));
        }
        // 释放资源
        rs.close();
        pstmt.close();
    }
    
    //   --------------------------------------------------------------------
//        学生查询信息
    public static void scor(Student student, int id) throws Exception {
        String sql = "select * from grade  where id=? ";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            student.setC4(rs.getInt("chinese"));
            student.setC5(rs.getInt("mathematics"));
            student.setC6(rs.getInt("english"));
            student.setC7(rs.getInt("chemistry"));
            student.setC8(rs.getInt("history"));
            student.setC9(rs.getInt("number"));
        }
        // 释放资源
        rs.close();
        pstmt.close();
    }
    
    //--------------------------------------------------------------------
//   学生类初始化--管理员
    public static void magstudent(List<BiologicalDirectory> list) throws Exception {
        String sqlStr = "select pk,\n" +
                "       Kingdom_cn,\n" +
                "       Kingdom_latin,\n" +
                "       Phylum_cn,\n" +
                "       Phylum_latin,\n" +
                "       Class_cn,\n" +
                "       Class_latin,\n" +
                "       Order_cn,\n" +
                "       Order_latin,\n" +
                "       Family_cn,\n" +
                "       Family_latin,\n" +
                "       Genus_cn,\n" +
                "       Genus_latin,\n" +
                "       Species_cn,\n" +
                "       Species_latin,\n" +
                "       auditor,\n" +
                "       directory_version\n" +
                "from biological_directory where 1=1 ";
        
        PreparedStatement pstmt = getConn().prepareStatement(sqlStr);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            // 数据映射
            Integer pk = rs.getInt("pk");
            String kingdomCn = rs.getString("Kingdom_cn");
            String kingdomLatin = rs.getString("Kingdom_latin");
            String phylumCn = rs.getString("Phylum_cn");
            String phylumLatin = rs.getString("Phylum_latin");
            String classCn = rs.getString("Class_cn");
            String classLatin = rs.getString("Class_latin");
            String orderCn = rs.getString("Order_cn");
            String orderLatin = rs.getString("Order_latin");
            String familyCn = rs.getString("Family_cn");
            String familyLatin = rs.getString("Family_latin");
            String genusCn = rs.getString("Genus_cn");
            String genusLatin = rs.getString("Genus_latin");
            String speciesCn = rs.getString("Species_cn");
            String speciesLatin = rs.getString("Species_latin");
            String auditor = rs.getString("auditor");
            String directoryVersion = rs.getString("directory_version");
            
            BiologicalDirectory biologicalDirectory = new BiologicalDirectory();
            biologicalDirectory.setPk(pk);
            biologicalDirectory.setKingdomCn(kingdomCn);
            biologicalDirectory.setKingdomLatin(kingdomLatin);
            biologicalDirectory.setPhylumCn(phylumCn);
            biologicalDirectory.setPhylumLatin(phylumLatin);
            biologicalDirectory.setClassCn(classCn);
            biologicalDirectory.setClassLatin(classLatin);
            biologicalDirectory.setOrderCn(orderCn);
            biologicalDirectory.setOrderLatin(orderLatin);
            biologicalDirectory.setFamilyCn(familyCn);
            biologicalDirectory.setFamilyLatin(familyLatin);
            biologicalDirectory.setGenusCn(genusCn);
            biologicalDirectory.setGenusLatin(genusLatin);
            biologicalDirectory.setSpeciesCn(speciesCn);
            biologicalDirectory.setSpeciesLatin(speciesLatin);
            biologicalDirectory.setAuditor(auditor);
            biologicalDirectory.setDirectoryVersion(directoryVersion);
            
            list.add(biologicalDirectory);
        }

        
        // 释放资源
        rs.close();
        pstmt.close();
    }
    
    //      --------------------------------------------------------------------
    // 删除学生界面
    public static boolean delete(int id) {
        String sql = "delete from rigister where id=?";
        return exeUpdate(sql, id);
    }
    
    // 查询界面
//    -----------------------------------------------------
// 模糊查询,多表查询++++++++++++++++姓名+++++++++++++++++
    public static void inquire(ArrayList<Student> list, String nam) throws Exception {
        
        String sql = "SELECT  g.id,g.number,name,r.`code`,r.sex,chinese,mathematics,english,history,chemistry,mathematics+chemistry+history+chinese+english 'peace',t.compellation FROM grade g,rigister r,teacher t WHERE t.number=g.number and g.id=r.id and name like ?;";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, "%" + nam + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            String code = rs.getString("code");
            String compellation = rs.getString("compellation");
            int id = rs.getInt("id");
            int number = rs.getInt("number");
            int chinese = rs.getInt("chinese");
            int mathematics = rs.getInt("mathematics");
            int english = rs.getInt("english");
            int chemistry = rs.getInt("chemistry");
            int history = rs.getInt("history");
            int peace = rs.getInt("peace");

//            封装数据
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setCode(code);
            student.setSex(sex);
            student.setNumber(number);
            student.setChinese(chinese);
            student.setEnglish(english);
            student.setChemistry(chemistry);
            student.setMathematics(mathematics);
            student.setHistory(history);
            student.setPeace(peace);
            student.setCompellation(compellation);
            list.add(student);
        }
        //        释放资源
        rs.close();
        pstmt.close();
    }
    
    //    -----------------------------------------------------
// 模糊查询,多表查询 ++++++++++++++++班级或姓名+++++++++++
    public static void inquire1(ArrayList<Student> list, String nam, int a) throws Exception {
        String sql = "";
        if (a == 1) {
            sql = "SELECT  g.id,g.number,name,r.`code`,r.sex,chinese,mathematics,english,history,chemistry,mathematics+chemistry+history+chinese+english 'peace',t.compellation FROM grade g,rigister r,teacher t WHERE t.number=g.number and g.id=r.id and name like ?;";
        } else if (a == 2) {
            sql = "SELECT  g.id,g.number,name,r.`code`,r.sex,chinese,mathematics,english,history,chemistry,mathematics+chemistry+history+chinese+english 'peace',t.compellation FROM grade g,rigister r,teacher t WHERE t.number=g.number and g.id=r.id and g.number like ?;";
        }
//        String sql = "SELECT  g.id,g.number,name,r.`code`,r.sex,chinese,mathematics,english,history,chemistry,mathematics+chemistry+history+chinese+english 'peace',t.compellation FROM grade g,rigister r,teacher t WHERE t.number=g.number and g.id=r.id and name like ?;";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, "%" + nam + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            String code = rs.getString("code");
            String compellation = rs.getString("compellation");
            int id = rs.getInt("id");
            int number = rs.getInt("number");
            int chinese = rs.getInt("chinese");
            int mathematics = rs.getInt("mathematics");
            int english = rs.getInt("english");
            int chemistry = rs.getInt("chemistry");
            int history = rs.getInt("history");
            int peace = rs.getInt("peace");

//            封装数据
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setCode(code);
            student.setSex(sex);
            student.setNumber(number);
            student.setChinese(chinese);
            student.setEnglish(english);
            student.setChemistry(chemistry);
            student.setMathematics(mathematics);
            student.setHistory(history);
            student.setPeace(peace);
            student.setCompellation(compellation);
            list.add(student);
        }
        //        释放资源
        rs.close();
        pstmt.close();
    }
    
    //    -----------------------------------------------------
// 模糊查询,多表查询 ++++++++++++++++班级和姓名+++++++++++
    public static void inquire2(ArrayList<Student> list, String nam, String gra) throws Exception {
        
        String sql = "SELECT  g.id,g.number,name,r.`code`,r.sex,chinese,mathematics,english,history,chemistry,mathematics+chemistry+history+chinese+english 'peace',t.compellation FROM grade g,rigister r,teacher t WHERE t.number=g.number and g.id=r.id and name like ? and g.number like ?;";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, "%" + nam + "%");
        pstmt.setString(2, "%" + gra + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            String code = rs.getString("code");
            String compellation = rs.getString("compellation");
            int id = rs.getInt("id");
            int number = rs.getInt("number");
            int chinese = rs.getInt("chinese");
            int mathematics = rs.getInt("mathematics");
            int english = rs.getInt("english");
            int chemistry = rs.getInt("chemistry");
            int history = rs.getInt("history");
            int peace = rs.getInt("peace");

//            封装数据
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setCode(code);
            student.setSex(sex);
            student.setNumber(number);
            student.setChinese(chinese);
            student.setEnglish(english);
            student.setChemistry(chemistry);
            student.setMathematics(mathematics);
            student.setHistory(history);
            student.setPeace(peace);
            student.setCompellation(compellation);
            list.add(student);
        }
        //        释放资源
        rs.close();
        pstmt.close();
    }
    
    //---------------------------------------------------------------------------------------
//    修改界面------------------学生数据读取-----------------------------
    public static void revamp1(Student student, String id) throws Exception {
        String sql = "select * from rigister  where id=?";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, id);
//    pstmt.setString(2, code);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            student.setC0(rs.getString("id"));
            student.setC1(rs.getString("name"));
            student.setC2(rs.getString("code"));
            student.setC3(rs.getString("sex"));
        }
        // 释放资源
        rs.close();
        pstmt.close();
    }
    
    public static void revamp2(Student student, String id) throws Exception {
        String sql = "select * from grade  where id=? ";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            student.setC4(rs.getInt("chinese"));
            student.setC5(rs.getInt("mathematics"));
            student.setC6(rs.getInt("english"));
            student.setC7(rs.getInt("chemistry"));
            student.setC8(rs.getInt("history"));
            student.setC9(rs.getInt("number"));
        }
        // 释放资源
        rs.close();
        pstmt.close();
    }
    
    //--------------------------------------------------------------------------
//    修改界面------------------学生数据更改------------------------
    public static boolean revamp3(String id, String name, String sex, String code) {
        String sql = " UPDATE rigister SET `name`=?,sex=?,code=?  WHERE id=?;";
        return exeUpdate(sql, name, sex, code, id);
    }
    
    public static boolean revamp4(String id, String chinese, String mathematics, String english, String chemistry, String history, String number) {
//        System.out.println(chinese);
        String sql = "update grade set chinese=?,mathematics=?,english=?,chemistry=?,history=?,number=? where id=?";
        return exeUpdate(sql, chinese, mathematics, english, chemistry, history, number, id);
    }
    
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //    教师信息初始化
    public static void initial(ArrayList<Student> list) throws Exception {
        String sql = "select * from teacher";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            //            获取数据
            String graduate = rs.getString("graduate");
            String sex = rs.getString("sex");
            String code = rs.getString("code");
            String compellation = rs.getString("compellation");
            String phone = rs.getString("phone");
            String salary = rs.getString("salary");
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            int number = rs.getInt("number");
//            封装数据
            Student student = new Student();
            student.setId(id);
            student.setGraduate(graduate);
            student.setCode(code);
            student.setSex(sex);
            student.setNumber(number);
            student.setCompellation(compellation);
            student.setAge(age);
            student.setPhone(phone);
            student.setSalary(salary);
            list.add(student);
        }
        //        释放资源
        rs.close();
        pstmt.close();
        
    }
    
    //    --------------------------------------------
//    -----管理员------模糊查询-------<<教师查询>>-----
    public static void initia(ArrayList<Student> list, String name) throws Exception {
        String sql = "select * from teacher where compellation like ?";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, "%" + name + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            //            获取数据
            String graduate = rs.getString("graduate");
            String sex = rs.getString("sex");
            String code = rs.getString("code");
            String compellation = rs.getString("compellation");
            String phone = rs.getString("phone");
            String salary = rs.getString("salary");
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            int number = rs.getInt("number");
//            封装数据
            Student student = new Student();
            student.setId(id);
            student.setGraduate(graduate);
            student.setCode(code);
            student.setSex(sex);
            student.setNumber(number);
            student.setCompellation(compellation);
            student.setAge(age);
            student.setPhone(phone);
            student.setSalary(salary);
            list.add(student);
        }
        //        释放资源
        rs.close();
        pstmt.close();
        
    }
    
    //    -----------------------------------------------------------------
//    修改界面---------------------------教师数据读取------------
    public static void ranp(Student student, String id) throws Exception {
        String sql = "select *from teacher where id=?";
        PreparedStatement pstmt = getConn().prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            student.setId(rs.getInt("id"));
            student.setCompellation(rs.getString("compellation"));
            student.setSex(rs.getString("sex"));
            student.setCode(rs.getString("code"));
            student.setNumber(rs.getInt("number"));
            student.setSalary(rs.getString("salary"));
            student.setAge(rs.getInt("age"));
            student.setPhone(rs.getString("phone"));
            student.setGraduate(rs.getString("graduate"));
        }
        //        释放资源
        rs.close();
        pstmt.close();
    }
    
    //    --------------------------------------------------------------------------------------
//    修改界面-------------------------------------教师数据修改------------------
    public static boolean ranp1(String id, String number, String compellation, String sex, String code, String age, String graduate, String salary, String phone) {
        
        String sql = "update teacher set number=?,compellation=?,sex=?,code=?,age=?,graduate=?,salary=?,phone=? where id=?";
        return exeUpdate(sql, number, compellation, sex, code, age, graduate, salary, phone, id);
    }
    
    //      --------------------------------------------------------------------
// 删除教师`界面
    public static boolean delete1(int id) {
        String sql = "delete from teacher where id=?";
        return exeUpdate(sql, id);
    }
    //-----------------------------------------------------------------------------
    
}