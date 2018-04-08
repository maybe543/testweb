package Application.service;

import Application.Dao.LogDao;
import Application.entity.*;
import Application.App;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class cloudservice {
	private String notify;
	private String calleeid;
	private String callerid;
	private String callid;
	private String flowdata;

	public JSONObject responseToSmartivr(JSONObject smart) {

		notify = smart.getString("notify");
		JSONObject respond = new JSONObject();
		switch (notify) {
		case "enter":
			// DataTable dt = Help.getDataTable("select top 1* from Question where
			// r_items_id=1 order by r_order");
			// if (dt != null && dt.Rows.Count > 0) {
			// flowdata = dt.Rows[0]["r_id"].ToString();
			// asr(dt.Rows[0]["r_name"].ToString());
			// }
			respond = play_background_asr();
			break;
		case "asrmessage_notify":
			// DataTable dt = Help.getDataTable("select top 1* from Question where
			// r_items_id=1 order by r_order");
			// if (dt != null && dt.Rows.Count > 0) {
			// flowdata = dt.Rows[0]["r_id"].ToString();
			// asr(dt.Rows[0]["r_name"].ToString());
			// }
			System.out.println("------asrmessage_notify-------" + smart.get("message"));
			respond = bridge(smart);
			break;
		case "asr_result":
			// if (smart.Errorcode == 0) {
			// PublicClass.SetLogs(null,
			// "Errorcode：" + smart.Message.Replace("。", "") + ":"
			// + "select top 1 * from QuestionOption where r_Question_id=" + smart.Flowdata
			// + " and r_OptionName = '" + smart.Message.Replace("。", "") + "'");// 提交日志;
			// DataTable dttt = Help.getDataTable("select * from QuestionOption where
			// r_Question_id=" + smart.Flowdata
			// + " and r_OptionName = '" + smart.Message.Replace("。", "").Replace("？", "") +
			// "'");
			// if (dttt != null && dttt.Rows.Count > 0) {
			// PublicClass.SetLogs(null, "dttt：" + smart.Message.Replace("。", ""));// 提交日志;
			// DataTable dtt = Help.getDataTable("select * from Question where r_items_id=1
			// and r_order="
			// + dttt.Rows[0]["r_NextQuestion"].ToString());
			// if (dtt != null && dtt.Rows.Count > 0) {
			// PublicClass.SetLogs(null, "dtt：" +
			// dttt.Rows[0]["r_NextQuestion"].ToString());// 提交日志;
			// flowdata = dtt.Rows[0]["r_id"].ToString();
			// asr(dtt.Rows[0]["r_name"].ToString());
			// }
			// } else {
			// PublicClass.SetLogs(null, "Errorcode：" + smart.Message.Replace("。", "") + ":"
			// + "select * from QuestionOption where r_Question_id=" + smart.Flowdata
			// + " and r_OptionName like '%" + smart.Message.Replace("。", "").Replace("？",
			// "") + "%'");// 提交日志;
			// dttt = Help.getDataTable("select * from QuestionOption where r_Question_id="
			// + smart.Flowdata
			// + " and r_OptionName like '%" + smart.Message.Replace("。", "").Replace("？",
			// "") + "%'");
			// if (dttt != null && dttt.Rows.Count > 0) {
			// PublicClass.SetLogs(null, "dttt：" + smart.Message.Replace("。", ""));// 提交日志;
			// DataTable dtt = Help.getDataTable("select * from Question where r_items_id=1
			// and r_order="
			// + dttt.Rows[0]["r_NextQuestion"].ToString());
			// if (dtt != null && dtt.Rows.Count > 0) {
			// PublicClass.SetLogs(null, "dtt：" +
			// dttt.Rows[0]["r_NextQuestion"].ToString());// 提交日志;
			// flowdata = dtt.Rows[0]["r_id"].ToString();
			// asr(dtt.Rows[0]["r_name"].ToString());
			// }
			// } else {
			// DataTable dtt = Help
			// .getDataTable("select * from Question where r_items_id=1 and r_name='' and
			// r_end='否'");
			// if (dtt != null && dtt.Rows.Count > 0) {
			// PublicClass.SetLogs(null, "dtt：" +
			// dttt.Rows[0]["r_NextQuestion"].ToString());// 提交日志;
			// flowdata = dtt.Rows[0]["r_id"].ToString();
			// asr(dtt.Rows[0]["r_name"].ToString());
			// } else {
			// dtt = Help.getDataTable("select * from Question where r_items_id=1 and
			// r_end='是'");
			// if (dtt != null && dtt.Rows.Count > 0) {
			// PublicClass.SetLogs(null, "dtt：" +
			// dttt.Rows[0]["r_NextQuestion"].ToString());// 提交日志;
			// flowdata = dtt.Rows[0]["r_id"].ToString();
			// asr(dtt.Rows[0]["r_name"].ToString());
			// }
			// }
			// }
			// }
			// if (smart.Message == "") {
			// asr("daikuan5.41.wav");
			// }
			// } else if (smart.Errorcode == -1) {
			// // asr("daikuan5.41.wav");
			// } else if (smart.Errorcode == -2) {
			// play_after_hangup("创建文件失败请联系管理员！", "", 0);
			// } else {
			// play_after_hangup("未知错误！", "", 0);
			// }
			break;
		case "getdtmf_result":
			// String dtmf = smart.Flowdata.SubString(7);
			// smart.Flowdata = "getdtmf" + smart.Message;
			// playback("你输入的按键是 " + smart.Message + "，上次输入的按键是 " + dtmf);
			break;
		case "playback_result":
			// if (smart.Flowdata.IndexOf("getdtmf") > 0) {
			// getdtmf("请继续输入按键", 1);
			// }
			// // else if (smart.Flowdata == "是的")
			// // {
			// // smart.Flowdata = "";
			// // asr("是的已经讲过了，继续说命令吧！");
			// // }
			// else if (smart.Flowdata == "vad") {
			// vad("请说话吧，后面是放音打断测试，语音活动检测(Voice Activity
			// Detection,VAD)又称语音端点检测,语音边界检测。目的是从声音信号流里识别和消除长时间的静音期，以达到在不降低业务质量的情况下节省话路资源的作用，它是IP电话应用的重要组成部分。静音抑制可以节省宝贵的带宽资源，可以有利于减少用户感觉到的端到端的时延。！");
			// } else {
			// // asr("请继续说命令吧！");
			// }
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
		return respond;
	}

	public JSONObject play_background_asr() {
		JSONObject respond = new JSONObject();

		respond.put("action", "start_asr");
		respond.put("flowdata", "流程选择");
		JSONObject params = new JSONObject();
		params.put("min_speak_ms", 100);
		params.put("max_speak_ms", 3000);
		params.put("min_pause_ms", 300);
		params.put("max_pause_ms", 600);
		params.put("pause_play_ms", 0);
		params.put("threshold", 0);
		params.put("recordpath", "");
		params.put("volume", 50);
		params.put("filter_level", 0.3);
		params.put("asr_configure_filename", "");
		respond.put("after_action", "playback");
		respond.put("after_ignore_error", false);
		JSONObject after_params = new JSONObject();
		after_params.put("prompt", "您好，欢迎致电顶顶通软件，这里是电话机器人演示系统，请说要进入的测试流程，比如，房产！");
		after_params.put("wait", 5000);
		after_params.put("retry", 0);
		respond.put("after_params", after_params);
		System.out.println(respond.toJSONString());
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
	// public String bridge(String number, String callerid, String gateway, String
	// prompt, String background) {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("number", typeof(String));
	// dt_params.Columns.Add("callerid", typeof(String));
	// dt_params.Columns.Add("gateway", typeof(String));
	// dt_params.Columns.Add("prompt", typeof(String));
	// dt_params.Columns.Add("background", typeof(String));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["number"] = number;
	// dr_params["callerid"] = callerid;
	// dr_params["gateway"] = gateway;
	// dr_params["prompt"] = prompt;
	// dr_params["background"] = background;
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "bridge";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "bridge：" + str);// 提交日志;
	// return str;
	// }
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("prompt", typeof(String));
	// dt_params.Columns.Add("max_waiting_ms", typeof(int));
	// dt_params.Columns.Add("retry", typeof(int));
	// dt_params.Columns.Add("mode", typeof(int));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["prompt"] =
	// "\u6b22\u8fce\u81f4\u7535\u9f0e\u9f0e\u8f6f\u4ef6\uff0c\u8bf7\u8bf4\u627e\u8c01";
	// dr_params["max_waiting_ms"] = "5000";
	// dr_params["retry"] = "3";
	// dr_params["mode"] = "0";
	// dt_params.Rows.Add(dr_params);

	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "asr";
	// dr["flowdata"] = "";
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);

	// Response.Write(json.ToJson(dt));
	// PublicClass.SetLogs(null, "smartivr首页加载：" + data + ":" + ":" + smart.Calleeid
	// + ":" + json.ToJson(dt));//提交日志;
	// switch (smart.Notify)
	// {
	// case "enter":
	// break;
	// }

	/// <summary>
	/// JSON转换为对象
	/// </summary>
	/// <typeparam name="T"></typeparam>
	/// <param name="jsonString"></param>
	/// <returns></returns>
	// public static T JsonToObject<T>(String jsonString)
	// {
	// T res = JsonConvert.DeserializeObject < T > (jsonString);
	// return res;
	// }
	//
	// public String hangup(String usermsg, int cause)
	// {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("cause", typeof(int));
	// dt_params.Columns.Add("usermsg", typeof(String));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["cause"] = cause;
	// dr_params["usermsg"] = usermsg;
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "hangup";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "hangup：" + str);//提交日志;
	// return str;
	// }
	//
	// public String play_after_hangup(String prompt, String usermsg, int cause)
	// {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("prompt", typeof(String));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["prompt"] = prompt;
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt_after_params = new DataTable();
	// dt_after_params.Columns.Add("cause", typeof(int));
	// dt_after_params.Columns.Add("usermsg", typeof(String));
	// DataRow dr_after_params = dt_after_params.NewRow();
	// dr_after_params["cause"] = cause;
	// dr_after_params["usermsg"] = usermsg;
	// dt_after_params.Rows.Add(dr_after_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// dt.Columns.Add("after_action", typeof(String));
	// dt.Columns.Add("after_params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "playback";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dr["after_action"] = "hangup";
	// dr["after_params"] = json.ToJson(dt_after_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "play_after_hangup：" + str);//提交日志;
	// return str;
	// }
	//
	// public String noop(String usermsg) {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("usermsg", typeof(String));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["usermsg"] = usermsg;
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "noop";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "noop：" + str);// 提交日志;
	// return str;
	// }
	//
	// public String playback(String prompt) {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("prompt", typeof(String));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["prompt"] = prompt;
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "playback";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "playback：" + str);// 提交日志;
	// return str;
	// }
	//
	// public String asr(String prompt)
	// {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("prompt", typeof(String));
	// dt_params.Columns.Add("max_waiting_ms", typeof(int));
	// dt_params.Columns.Add("retry", typeof(int));
	// dt_params.Columns.Add("mode", typeof(int));
	// dt_params.Columns.Add("disable_asr", typeof(object));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["prompt"] = prompt;
	// dr_params["max_waiting_ms"] = "5000";
	// dr_params["retry"] = "0";
	// dr_params["mode"] = "0";
	// dr_params["disable_asr"] = "false";
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "asr";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "asr：" + str);//提交日志;
	// return str;
	// }
	//
	// public String vad(String prompt)
	// {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("prompt", typeof(String));
	// dt_params.Columns.Add("max_waiting_ms", typeof(int));
	// dt_params.Columns.Add("min_pause_ms", typeof(int));
	// dt_params.Columns.Add("retry", typeof(int));
	// dt_params.Columns.Add("mode", typeof(int));
	// dt_params.Columns.Add("disable_asr", typeof(object));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["prompt"] = prompt;
	// dr_params["max_waiting_ms"] = "5000";
	// dr_params["min_pause_ms"] = "600";
	// dr_params["retry"] = "0";
	// dr_params["mode"] = "0";
	// dr_params["disable_asr"] = "true";
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "asr";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "vad：" + str);//提交日志;
	// return str;
	// }
	//

	//
	// public String deflect(String number) {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("number", typeof(String));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["number"] = number;
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "deflect";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "deflect：" + str);// 提交日志;
	// return str;
	// }
	//
	// public String getdtmf(String prompt, int max)
	// {
	// DataTable dt_params = new DataTable();
	// dt_params.Columns.Add("prompt", typeof(String));
	// dt_params.Columns.Add("invalid_prompt", typeof(String));
	// dt_params.Columns.Add("min", typeof(int));
	// dt_params.Columns.Add("max", typeof(int));
	// dt_params.Columns.Add("tries", typeof(int));
	// dt_params.Columns.Add("timeout", typeof(int));
	// dt_params.Columns.Add("digit_timeout", typeof(int));
	// dt_params.Columns.Add("terminators", typeof(String));
	// DataRow dr_params = dt_params.NewRow();
	// dr_params["prompt"] = prompt;
	// dr_params["invalid_prompt"] = "按键无效";
	// dr_params["min"] = "0";
	// dr_params["max"] = max;
	// dr_params["tries"] = "1";
	// dr_params["timeout"] = "5000";
	// dr_params["digit_timeout"] = "3000";
	// dr_params["terminators"] = "#";
	// dt_params.Rows.Add(dr_params);
	//
	// DataTable dt = new DataTable();
	// dt.Columns.Add("action", typeof(String));
	// dt.Columns.Add("flowdata", typeof(String));
	// dt.Columns.Add("params", typeof(object));
	// DataRow dr = dt.NewRow();
	// dr["action"] = "getdtmf";
	// dr["flowdata"] = flowdata;
	// dr["params"] = json.ToJson(dt_params);
	// dt.Rows.Add(dr);
	//
	// String str = json.ToJson(dt);
	// Response.Write(str);
	// PublicClass.SetLogs(null, "getdtmf：" + str);//提交日志;
	// return str;
	// }
	// }
	//
	// public class Smart {
	// private String notify = String.Empty;
	// private String calleeid = String.Empty;
	// private String callerid = String.Empty;
	// private String callid = String.Empty;
	// private String flowdata = String.Empty;
	// private int errorcode;
	// private String message = String.Empty;
	//
	// public String Message
	// {
	// get { return message; }
	// set { message = value; }
	// }
	//
	// public int Errorcode
	// {
	// get { return errorcode; }
	// set { errorcode = value; }
	// }
	//
	// public String Flowdata
	// {
	// get { return flowdata; }
	// set { flowdata = value; }
	// }
	//
	// /// <summary>
	// /// 通话ID
	// /// </summary>
	// public String Callid
	// {
	// get { return callid; }
	// set { callid = value; }
	// }
	//
	// /// <summary>
	// /// 通话被叫号码
	// /// </summary>
	// public String Callerid
	// {
	// get { return callerid; }
	// set { callerid = value; }
	// }
	//
	// /// <summary>
	// /// 通话被叫号码
	// /// </summary>
	// public String Calleeid
	// {
	// get { return calleeid; }
	// set { calleeid = value; }
	// }
	//
	// /// <summary>
	// /// 通知类型
	// /// </summary>
	// public String Notify
	// {
	// get { return notify; }
	// set { notify = value; }
	// }

}
