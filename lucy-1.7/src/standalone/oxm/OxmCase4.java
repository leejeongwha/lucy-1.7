package oxm;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import lucy17.www.sample.oxm.model.MemberDocument;
import lucy17.www.sample.oxm.model.MemberDocument.Member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/oxm/applicationContext4.xml")
public class OxmCase4 {
	@Autowired
	private Marshaller mashaller;
	
	@Autowired 
	private Unmarshaller unMashaller;
	
	@Test
	public void testMashaller() throws Exception {
		MemberDocument memberDoc = MemberDocument.Factory.newInstance();
		
		Member member = memberDoc.addNewMember();
		
		member.setId("id");
		member.setName("name");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamResult sr = new StreamResult(baos);
		
		mashaller.marshal(memberDoc, sr);
		System.out.println(baos.toString());
	}
	
	@Test
	public void testUnMashaller() throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<mod:member xmlns:mod=\"http://www.lucy_1_7/sample/oxm/model\">" +
				"<id>id</id><name>name</name></mod:member>";
		
		MemberDocument memberDoc = (MemberDocument) unMashaller.unmarshal(new StreamSource(new StringReader(xml)));
		
		System.out.println(memberDoc);
	}
}
