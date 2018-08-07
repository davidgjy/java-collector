package org.genesis.jaxb.list.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: DateAdapter
 * @Package org.genesis.jaxb.list.adapter
 * @Description: date adapter
 * @date 2018/8/7 14:28
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    private static final DateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String date) throws Exception {
        return SDF.parse(date);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return SDF.format(date);
    }
}
