package oxm;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import oxm.model.JibxMember;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/oxm/applicationContext2.xml")
public class OxmCase2 {
	@Autowired 
	private Marshaller mashaller;
	
	@Autowired 
	private Unmarshaller unMashaller;
	
	@Test
	public void testMashaller() throws Exception {
		JibxMember member = new JibxMember();
		member.setId("id");
		member.setName("name");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamResult sr = new StreamResult(baos);
		
		mashaller.marshal(member, sr);
		System.out.println(baos.toString());
	}
	
	@Test
	public void testUnMashaller() throws Exception {
		String xml = "<member><id>id</id><name>name</name></member>";
		
		JibxMember member = (JibxMember) unMashaller.unmarshal(new StreamSource(new StringReader(xml)));
		
		System.out.println(member);
	}
}
