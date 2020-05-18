import org.junit.Test;

import java.io.*;

/**
 * @program springbootcachedemo
 * @description: 替换字段
 * @author: xielinzhi
 * @create: 2019/05/24 10:13
 */


public class ReplaceWords {

    @Test
    public void replaceWords() throws  Exception{
        File file = new File("/Users/xielinzhi/Downloads/OL39_POTL_RAMS_OL_CHECKLIST_RISKS.sql");
        String origin = "OL39_POTL.";
        String replaced = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line=null;
        CharArrayWriter caw=new CharArrayWriter();
        //以行为单位进行遍历
        while((line=br.readLine())!=null){
            //替换每一行中符合被替换字符条件的字符串
            line=line.replaceAll(origin, replaced);
            //将该行写入内存
            caw.write(line);
            //添加换行符，并进入下次循环
            caw.append(System.getProperty("line.separator"));
        }
        //关闭输入流
        br.close();

        //将内存中的流写入源文件
        FileWriter fw=new FileWriter(file);
        caw.writeTo(fw);
        fw.close();

    }

    @Test
    public void getlen(){
        String temp = "ACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E7765622E7361766564726571756573742E44656661756C745361766564526571756573741E404844F936649402000E49000A736572766572506F72744C000B636F6E74657874506174687400124C6A6176612F6C616E672F537472696E673B4C0007636F6F6B6965737400154C6A6176612F7574696C2F41727261794C6973743B4C00076865616465727374000F4C6A6176612F7574696C2F4D61703B4C00076C6F63616C657371007E00024C00066D6574686F6471007E00014C000A706172616D657465727371007E00034C000870617468496E666F71007E00014C000B7175657279537472696E6771007E00014C000A7265717565737455524971007E00014C000A7265717565737455524C71007E00014C0006736368656D6571007E00014C000A7365727665724E616D6571007E00014C000B736572766C65745061746871007E00017870000029AE7400082F62732F72756C65737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000002770400000002737200396F72672E737072696E676672616D65776F726B2E73656375726974792E7765622E7361766564726571756573742E5361766564436F6F6B696503402B829FC0B4660200084900066D61784167655A000673656375726549000776657273696F6E4C0007636F6D6D656E7471007E00014C0006646F6D61696E71007E00014C00046E616D6571007E00014C00047061746871007E00014C000576616C756571007E00017870FFFFFFFF00000000007070740013706F7274616C5F62697A6C696E655F636F64657074000442414E4B7371007E0008FFFFFFFF0000000000707074000753455353494F4E707400305932566C597A457959544174595442685A5330305A544E6D4C574669597A55744D6D4E6A5A574E6B4E5459314E6D4A6978737200116A6176612E7574696C2E547265654D61700CC1F63E2D256AE60300014C000A636F6D70617261746F727400164C6A6176612F7574696C2F436F6D70617261746F723B78707372002A6A6176612E6C616E672E537472696E672443617365496E73656E736974697665436F6D70617261746F7277035C7D5C50E5CE02000078707704000000067400066163636570747371007E0006000000017704000000017400032A2F2A7874000F6163636570742D656E636F64696E677371007E00060000000177040000000174000C677A69702C6465666C6174657874000A636F6E6E656374696F6E7371007E00060000000177040000000174000A4B6565702D416C69766578740006636F6F6B69657371007E000600000002770400000002740018706F7274616C5F62697A6C696E655F636F64653D42414E4B74003853455353494F4E3D5932566C597A457959544174595442685A5330305A544E6D4C574669597A55744D6D4E6A5A574E6B4E5459314E6D4A6978740004686F73747371007E00060000000177040000000174001231302E3130302E312E3135363A31303637307874000A757365722D6167656E747371007E0006000000017704000000017400284170616368652D48747470436C69656E742F342E352E3320284A6176612F312E382E305F3134342978787371007E000600000001770400000001737200106A6176612E7574696C2E4C6F63616C657EF811609C30F9EC03000649000868617368636F64654C0007636F756E74727971007E00014C000A657874656E73696F6E7371007E00014C00086C616E677561676571007E00014C000673637269707471007E00014C000776617269616E7471007E00017870FFFFFFFF7400025553740000740002656E71007E002B71007E002B78787400034745547371007E000F70770400000001740006706172616D73757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B470200007870000000017400127B2262697A4C696E65223A2242414E4B227D7870740025706172616D733D25374225323262697A4C696E652532323A25323242414E4B25323225374474001D2F62732F72756C652F72732F646D2F7269736B4C6162656C2F6C697374740036687474703A2F2F31302E3130302E312E3135363A31303637302F62732F72756C652F72732F646D2F7269736B4C6162656C2F6C6973747400046874747074000C31302E3130302E312E3135367400152F72732F646D2F7269736B4C6162656C2F6C697374";
        System.out.println(temp.length());
    }
}