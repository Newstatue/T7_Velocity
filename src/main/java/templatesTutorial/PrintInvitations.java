//package templatesTutorial;
//
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//
//import java.beans.XMLDecoder;
//import java.io.*;
//import java.util.List;
//
//public class PrintInvitations {
//
//    public static void main(String[] args) {
//        try {
//            // 1. 读取XML文件中的朋友数据
//            FileInputStream fis = new FileInputStream("friends.xml");
//            XMLDecoder decoder = new XMLDecoder(fis);
//            List<Person> friends = (List<Person>) decoder.readObject();
//            decoder.close();
//            fis.close();
//
//            // 2. 设置Velocity模板引擎
//            VelocityEngine velocityEngine = new VelocityEngine();
//            velocityEngine.init();
//
//            // 3. 加载模板
//            Template template = velocityEngine.getTemplate("src/main/resources/invitation_template.vm");
//
//            // 4. 准备输出文件
//            FileWriter writer = new FileWriter("invitations.txt");
//
//            // 5. 为每个朋友生成个性化邀请函
//            for (Person friend : friends) {
//                VelocityContext context = new VelocityContext();
//                context.put("person", friend);
//                StringWriter stringWriter = new StringWriter();
//                template.merge(context, stringWriter);
//
//                writer.write(stringWriter.toString());
//                writer.write("\n------------------------------------------------\n");
//            }
//
//            writer.close();
//            System.out.println("Invitations generated successfully!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


package templatesTutorial;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.beans.XMLDecoder;
import java.io.*;
import java.util.List;

public class PrintInvitations {

    public static void main(String[] args) {
        try {
            // 1. 读取XML文件中的朋友数据
            FileInputStream fis = new FileInputStream("friends.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            List<Person> friends = (List<Person>) decoder.readObject();
            decoder.close();
            fis.close();

            // 2. 设置Velocity模板引擎
            VelocityEngine velocityEngine = new VelocityEngine();
            velocityEngine.init();

            // 3. 加载HTML模板
            Template template = velocityEngine.getTemplate("src/main/resources/invitation_template.vm");

            // 4. 使用HTML文件输出邀请函
            FileWriter writer = new FileWriter("invitations.html");

            // 5. 为每个朋友生成个性化邀请函
            for (Person friend : friends) {
                VelocityContext context = new VelocityContext();
                context.put("person", friend);
                StringWriter stringWriter = new StringWriter();
                template.merge(context, stringWriter);

                writer.write(stringWriter.toString());
                writer.write("\n");
            }

            writer.close();
            System.out.println("HTML invitations generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
