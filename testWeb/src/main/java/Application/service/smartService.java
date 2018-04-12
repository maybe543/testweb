package Application.service;

import Application.Dao.LogDao;
import Application.entity.*;
import Application.App;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class smartService {

	@Autowired
	private Environment env;

	public JSONObject responseToSmartivr(JSONObject smart) {

		String notify = smart.getString("notify");
		JSONObject respond = new JSONObject();
		System.out.println(smart);
		switch (notify) {
		case "enter":

			System.out.println("enter ------enter");

			respond = play_background_asr(smart);
			break;
		case "asrprogress_notify":

			System.out.println("------asrprogress_notify-------");

			// if(设置需要打断)
			// respond=console_playback("pause");
			// else
			// if(smart.getString("message")==""||(int)smart.get("errorcode")!=0) {
			// respond = noop("noop action");
			// System.out.println("------asrprogress_notify-------noop" );
			// }
			//
			// else {
			// respond = noop("noop action");
			// System.out.println("------asrprogress_notify-------pause" );
			// }
			// break;
		case "asrmessage_notify":
			// DataTable dt = Help.getDataTable("select top 1* from Question where
			// r_items_id=1 order by r_order");
			// if (dt != null && dt.Rows.Count > 0) {
			// flowdata = dt.Rows[0]["r_id"].ToString();
			// asr(dt.Rows[0]["r_name"].ToString());
			// }
			// if(设置需要打断)
			// respond=console_playback("pause");
			// else
			// respond = noop("noop action");//
			System.out.println("------asrmessage_notify-------");

			// respond = noop("noop action");
			respond = playback(env.getProperty("humanAudio") + "maifang.wav", "maifang", 500, 2);
			break;
		case "asr_result":

			break;
		case "getdtmf_result":

			break;
		case "playback_result":

			break;
		case "bridge_result":
			if ((int) smart.get("Errorcode") == 0) {
				System.out.println("呼叫分机成功，请继续测试");
			} else {
				System.out.println("呼叫分机失败，错误代码 " + (int) smart.get("Errorcode") + " 请继续测试");
			}
			break;
		case "leave":
			// noop("");
			break;
		default:
			// play_after_hangup("未知通知类型", "", 0);
			break;
		}

		System.out.println("respond is ---->" + respond);
		return respond;
	}

	public JSONObject play_background_asr(JSONObject smart) {
		JSONObject respond = new JSONObject();

		respond.put("action", "start_asr");
		respond.put("flowdata", "流程选择");
		JSONObject params = new JSONObject();
		params.put("min_speak_ms", 100);
		params.put("max_speak_ms", 3000);
		params.put("min_pause_ms", 300);
		params.put("max_pause_ms", 800);
		params.put("pause_play_ms", 200);// 设置打断
		params.put("threshold", 0);

		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String today = df.format(Calendar.getInstance().getTime());
		String recordpath = env.getProperty("SmartAudioFloder") + today + "/" + smart.getString("callerid");
		params.put("recordpath", recordpath);
		System.out.println(recordpath + "set   -----   record");
		params.put("volume", 50);
		params.put("filter_level", 0.3);
		params.put("asr_configure_filename", "");
		respond.put("params", params);
		respond.put("after_action", "playback");
		respond.put("after_ignore_error", false);
		JSONObject after_params = new JSONObject();
		after_params.put("prompt", env.getProperty("humanAudio") + "maifang.wav");
		after_params.put("wait", 5000);
		after_params.put("retry", 0);
		respond.put("after_params", after_params);
		System.out.println(respond.toJSONString());
		return respond;
	}

	public JSONObject playback(String prompt, String flowdata, int wait, int retry) {
		JSONObject respond = new JSONObject();

		respond.put("action", "playback");
		respond.put("flowdata", "flowdata");
		JSONObject params = new JSONObject();
		params.put("prompt", prompt);
		params.put("wait", wait);
		params.put("retry", retry);
		respond.put("params", params);

		return respond;
	}

	public JSONObject console_playback(String cmd) {
		JSONObject respond = new JSONObject();

		respond.put("action", "console_playback");
		respond.put("flowdata", "");
		JSONObject params = new JSONObject();
		params.put("command", cmd);
		respond.put("params", params);

		return respond;
	}

	// bridge 转接电话
	// {"action":"bridge","flowdata":"","params":{"number":"sofia\/external\/a8008@sip.ddrj.com:16080",
	// "callerid":"","gateway":"","prompt":"\u6b63\u5728\u8f6c\u63a5\u4e2d\uff0c\u8bf7\u7b49\u5f85","background":"wating.wav"}}
	// number 被叫号码，如果gateway没设置，必须是完整呼叫串类似:sofia/external/电话号码@网关Ip
	// callerid 可选参数 主叫号码（对方看到的来电显示）
	// gateway 可选参数 网关名字
	// background 可选参数 背景音乐
	// prompt 可选参数 提示文本 prompt 提示文本（如果最后4个字是.wav，就是录音文件放音，否则会调用TTS生成声音文件）。
	// smart{
	// "calleeid": "8888abc",
	// "callerid": "abc",
	// "callid": "ea6d1235-aaab-4251-b03b-3b53ca32e00d",
	// "errorcode": 0,
	// "flowdata": "流程选择",
	// "flowid": "abc",
	// "message": "1.你好；2.什么事；",
	// "notify": "asrmessage_notify",
	// "speakms": "1162" //整句话的说话时间，包含暂停时间
	// }
	public JSONObject bridge(JSONObject smart) {
		JSONObject respond = new JSONObject();

		respond.put("action", "bridge");
		respond.put("flowdata", "");
		JSONObject params = new JSONObject();
		params.put("number", "sofia/internal/sip:1000@192.168.31.182:5060");
		params.put("callerid", "");
		params.put("gateway", "");
		params.put("prompt", "");
		params.put("background", "");
		respond.put("params", params);
		System.out.println(respond.toJSONString());
		return respond;
	}

	public JSONObject noop(String usermsg) {
		JSONObject respond = new JSONObject();

		respond.put("action", "noop");
		JSONObject params = new JSONObject();
		params.put("usermsg", "usermsg");
		respond.put("params", params);
		return respond;

	}

	public JSONObject hangup(String usermsg) {
		JSONObject respond = new JSONObject();

		respond.put("action", "hangup");
		JSONObject params = new JSONObject();
		params.put("usermsg", "usermsg");
		respond.put("params", params);
		return respond;

	}

}
