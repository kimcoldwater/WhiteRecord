package cs.projects.whiterecord.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.fasterxml.jackson.databind.ObjectMapper;

import cs.projects.whiterecord.controller.DensityController;
import cs.projects.whiterecord.model.Density;
import cs.projects.whiterecord.service.DensityService;
import cs.projects.whiterecord.service.SocialService;
import cs.projects.whiterecord.vo.SafeCasterVO;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerApplication.class);

	@Autowired
	private SocialService socialService;
	
	@Autowired
	private DensityService densityService;
	
    @Scheduled(cron = "1 0 0 * * *")
    public void printDate () throws Exception{
    	System.out.println("스케쥴러 작동");
       socialService.socialSchedul();
    }
    
    @Scheduled(cron = "0 0 12 * 12,1,2,3 *")
    public void insertDensity() throws Exception{
		logger.info("density스케쥴러 작동");
    	LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
		LocalDate day6upAgo = now.plusDays(6);
    	//당일날짜 기준 3일 후 오전 10시에 예측데이터가 기록데이터로 업데이트 됨
		LocalDate day1downAgo = now.minusDays(4);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		// 포맷 적용
		String formated6Ago = day6upAgo.format(formatter);
		String formated1Ago = day1downAgo.format(formatter);
		logger.info(formated6Ago);
		logger.info(formated1Ago);
		

		
		List<Map<String,Object>> resort = new ArrayList<Map<String,Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("resort", "휘닉스");
		map1.put("zipCd", "25307");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("resort", "용평");
		map2.put("zipCd", "25352");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("resort", "비발디");
		map3.put("zipCd", "25102");
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("resort", "지산");
		map4.put("zipCd", "17390");
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("resort", "곤지암");
		map5.put("zipCd", "12809");
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("resort", "웰리힐리");
		map6.put("zipCd", "25263");
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("resort", "하이원");
		map7.put("zipCd", "26154");
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("resort", "베어스");
		map8.put("zipCd", "11188");
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("resort", "엘리시안");
		map9.put("zipCd", "24464");
		Map<String, Object> map10 = new HashMap<String, Object>();
		map10.put("resort", "오크밸리");
		map10.put("zipCd", "26357");
		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put("resort", "무주");
		map11.put("zipCd", "55556");
		Map<String, Object> map12 = new HashMap<String, Object>();
		map12.put("resort", "알펜시아");
		map12.put("zipCd", "25351");
		Map<String, Object> map13 = new HashMap<String, Object>();
		map13.put("resort", "에덴밸리");
		map13.put("zipCd", "50584");
		Map<String, Object> map14 = new HashMap<String, Object>();
		map14.put("resort", "오투");
		map14.put("zipCd", "26010");
		
		resort.add(map1);
		resort.add(map2);
		resort.add(map3);
		resort.add(map4);
		resort.add(map5);
		resort.add(map6);
		resort.add(map7);
		resort.add(map8);
		resort.add(map9);
		resort.add(map10);
		resort.add(map11);
		resort.add(map12);
		resort.add(map13);
		resort.add(map14);

		//6일 후 예측데이터값을 insert
		for(int i = 0 ; i<resort.size(); i++) {
		  URL url = new URL("https://apis.openapi.sk.com/safecaster/v1/search/safetyindex/zip/day/hour?zipCd="+resort.get(i).get("zipCd")+"&baseYmd="+formated6Ago);
		  ObjectMapper mapper = new ObjectMapper();
		  StringBuilder sb = new StringBuilder();
		  BufferedReader br;

		    HttpURLConnection con = (HttpURLConnection)url.openConnection();

		    //Request Header 정의
		    con.setRequestProperty("appKey", "l7xxd2da36f3719b4b7aa4718a84ea8724f8");

		    //전송방식
		    con.setRequestMethod("GET");

		    //서버에 연결되는 Timeout 시간 설정
		    con.setConnectTimeout(5000);

		    //InputStream 읽어 오는 Timeout 시간 설정
		    con.setReadTimeout(5000); 

		    //URLConnection에 대한 doOutput 필드값을 지정된 값으로 설정한다. 
		    //URL 연결은 입출력에 사용될 수 있다. 
		    //URL 연결을 출력용으로 사용하려는 경우 DoOutput 플래그를 true로 설정하고, 
		    //그렇지 않은 경우는 false로 설정해야 한다. 기본값은 false이다.
		    // true로 설정하면 자동으로 POST로 설정된다.
		    con.setDoOutput(false); 


		      br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		      String line;
		      while ((line = br.readLine()) != null) {
		      sb.append(line);
		      }
		      br.close();
		      SafeCasterVO safeCasterVO = mapper.readValue(sb.toString(), SafeCasterVO.class);		      
		      Density density = new Density();
		      
		      String resortName = resort.get(i).get("resort").toString();
		      density.setResort(resortName);
		      density.setT00(safeCasterVO.getData().get(0).getFlowDensityPercentile());
		      density.setT03(safeCasterVO.getData().get(3).getFlowDensityPercentile());
		      density.setT09(safeCasterVO.getData().get(9).getFlowDensityPercentile());
		      density.setT12(safeCasterVO.getData().get(12).getFlowDensityPercentile());
		      density.setT15(safeCasterVO.getData().get(15).getFlowDensityPercentile());
		      density.setT18(safeCasterVO.getData().get(18).getFlowDensityPercentile());
		      density.setT21(safeCasterVO.getData().get(21).getFlowDensityPercentile());
		      densityService.dataInsert(density);

		}
		
		//예측데이터값을 regdate날짜를 지난 후 기록데이터값으로 update 
		for(int i = 0 ; i<resort.size(); i++) {
		  URL url = new URL("https://apis.openapi.sk.com/safecaster/v1/search/safetyindex/zip/day/hour?zipCd="+resort.get(i).get("zipCd")+"&baseYmd="+formated1Ago);
		  ObjectMapper mapper = new ObjectMapper();
		  StringBuilder sb = new StringBuilder();
		  BufferedReader br;

		    HttpURLConnection con = (HttpURLConnection)url.openConnection();

		    //Request Header 정의
		    con.setRequestProperty("appKey", "l7xxd2da36f3719b4b7aa4718a84ea8724f8");

		    //전송방식
		    con.setRequestMethod("GET");

		    //서버에 연결되는 Timeout 시간 설정
		    con.setConnectTimeout(5000);

		    //InputStream 읽어 오는 Timeout 시간 설정
		    con.setReadTimeout(5000); 

		    //URLConnection에 대한 doOutput 필드값을 지정된 값으로 설정한다. 
		    //URL 연결은 입출력에 사용될 수 있다. 
		    //URL 연결을 출력용으로 사용하려는 경우 DoOutput 플래그를 true로 설정하고, 
		    //그렇지 않은 경우는 false로 설정해야 한다. 기본값은 false이다.
		    con.setDoOutput(false); 


		      br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		      String line;
		      while ((line = br.readLine()) != null) {
		      sb.append(line);
		      }
		      br.close();
		      SafeCasterVO safeCasterVO = mapper.readValue(sb.toString(), SafeCasterVO.class);		      
		      Density densityUp = new Density();
		      
		      String resortName = resort.get(i).get("resort").toString();
		      densityUp.setResort(resortName);
		      densityUp.setT00(safeCasterVO.getData().get(0).getFlowDensityPercentile());
		      densityUp.setT03(safeCasterVO.getData().get(3).getFlowDensityPercentile());
		      densityUp.setT09(safeCasterVO.getData().get(9).getFlowDensityPercentile());
		      densityUp.setT12(safeCasterVO.getData().get(12).getFlowDensityPercentile());
		      densityUp.setT15(safeCasterVO.getData().get(15).getFlowDensityPercentile());
		      densityUp.setT18(safeCasterVO.getData().get(18).getFlowDensityPercentile());
		      densityUp.setT21(safeCasterVO.getData().get(21).getFlowDensityPercentile());
		      densityService.densityUpdate(densityUp);
		}
		
    }

    
}
