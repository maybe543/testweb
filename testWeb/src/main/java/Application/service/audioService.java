package Application.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.hibernate.boot.archive.internal.ByteArrayInputStreamAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import Application.Dao.audioDao;

@Service
public class audioService {

	@Autowired
	private Environment env;
	@Autowired
	audioDao audDao;

	public JSONObject test() throws Exception {
		JSONObject testaudio = new JSONObject();
		// System.out.println(smart);
		System.out.println("begin to send to respondse");

		AudioInputStream audioInputStream1 = audDao.getAudio("13599039564", "20180412",
				"605e1c3e-3e69-11e8-8fbb-c16a403646a5", "1");

		AudioFormat audioFormat = audioInputStream1.getFormat();
		testaudio.put("合并前", "合并前---");
		testaudio.put("每秒播放帧数：", audioFormat.getSampleRate());
		testaudio.put("总帧数：", audioInputStream1.getFrameLength());
		testaudio.put("音频时长（秒）：", audioInputStream1.getFrameLength() / audioFormat.getSampleRate());
		System.out.println(testaudio);
		AudioInputStream audioInputStream2 = audDao.getAudio("13599039564", "20180412",
				"605e1c3e-3e69-11e8-8fbb-c16a403646a5", "2");

		List<AudioInputStream> audios = new ArrayList<AudioInputStream>();
		audios.add(audioInputStream1);
		audios.add(audioInputStream2);

		AudioInputStream audioBuild = audDao.merge(audios);

		JSONObject testAudiobject = new JSONObject();
		testAudiobject.put("合并后", "合并后---");
		testAudiobject.put("每秒播放帧数：", audioBuild.getFormat().getSampleRate());
		testAudiobject.put("总帧数：", audioBuild.getFrameLength());
		testAudiobject.put("音频时长（秒）：", audioBuild.getFrameLength());
		testAudiobject.put("audioBuild", audioBuild);
		
		String filename = env.getProperty("humanAudio") + "merge.wav";

		AudioInputStream ais = (AudioInputStream) testAudiobject.get("audioBuild");

		System.out.println("reload ----   ");
		System.out.println("每秒播放帧数：" + ais.getFormat().getSampleRate());
		System.out.println("总帧数：" + ais.getFrameLength());
		System.out.println("音频时长（秒）：" + ais.getFrameLength());

		audDao.write(filename, ais);

		return testaudio;
		// try {
		// mergeAndWrite(filename, audios);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// AudioInputStream mergeresult = audDao.read(filename);
		// AudioFormat audioFormat1 = mergeresult.getFormat();
		// smart.put("合并后", "合并后---");
		// smart.put("每秒播放帧数：", audioFormat1.getSampleRate());
		// smart.put("总帧数：", mergeresult.getFrameLength());
		// smart.put("音频时长（秒）：", mergeresult.getFrameLength() /
		// audioFormat1.getSampleRate());
		// // smart.put("hello", "hello");
		// return smart;
	}

}
