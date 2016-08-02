package util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.surf.information.sites.model.SitesVO;

public class JsoupCrawlerUT {
	public static void main(String[] args){
//		  //URL 以yahoo股票為測試
//		Document doc = null;
//		try{
//		URL url = new URL("http://www.cwb.gov.tw/V7/forecast/");
//		/*
//         * 向網頁伺服發出請求，並將回應分析成document。
//         * 第一個參數是：請求位置與QueryString。
//         * 第二個參數是：連線時間(毫秒)，在指定時間內若無回應則會丟出IOException
//         */       
//		doc = Jsoup.parse(url, 3000);
//		}catch (Exception e){
//		}
//		Elements divs = doc.select("div.FooterContentThree");
//		Iterator<Element> iterator;
//		Element  div;
//		Elements a = divs.get(0).select("ul>li");
//		iterator=a.iterator();
//		while(iterator.hasNext()){
//			Element t=iterator.next();
//			System.out.println("data" + ": " + t.text().trim());
//		}
//		iterator = a.select("th").iterator();
//		while(iterator.hasNext())
//        {               
//            System.out.println("data" + ": " + iterator.next().text().trim());
//        }   
		
		
		  //URL 以yahoo股票為測試
			Document doc = null;
			try{
			String url="http://sports.ettoday.net/news-tag/%E8%A1%9D%E6%B5%AA";
			doc=Jsoup.connect(url).get();
//			System.out.println(doc.toString());
			}catch (Exception e){
			}
			Elements tables = doc.select("div");
//			Iterator<Element> iter = tables.iterator();
//			while(iter.hasNext()){
//				Element title = iter.next();
//				String titleString=title.text();
//				System.out.println(titleString);
//				SitesVO bean = new SitesVO();
//				bean.setName(titleString);
//			}
//			System.out.println(tables.size());
			System.out.println(tables.toString());
			
	}
}