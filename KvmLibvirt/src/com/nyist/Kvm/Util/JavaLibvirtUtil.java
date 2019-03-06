package com.nyist.Kvm.Util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;

public class JavaLibvirtUtil {

    public Connect conn;




    public Domain DomainUtil() throws LibvirtException, DocumentException {
        conn=new Connect("qemu:///system", false);
        SAXReader reader = new SAXReader();
        Document docu = reader.read(new File("/etc/libvirt/qemu/demo.xml"));
        String xmlDesc = docu.asXML();
        Domain domain = conn.domainDefineXML(xmlDesc);
        return domain;
    }
    public Connect JavaLibUtil(){
        return conn;
    }


}

