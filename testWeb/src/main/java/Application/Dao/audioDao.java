package Application.Dao;

import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.net.URL;
import java.util.List;

import javax.sound.sampled.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class audioDao {

	@Autowired
	private Environment env;

	// 从机器人服务器读取 某一个index的音频
	public AudioInputStream getAudio(String callerid, String day, String callid, String Index) throws Exception {
		// String floder = "http://localhost/audio/";
		String floder = "http://" + env.getProperty("SmartIP") + "/audio/" + day + "/" + callerid + "/";

		String filename = floder + callerid + "_" + callid + "_" + Index + ".wav";
		URL url = new URL(filename);
		System.out.println("in model------" + url.toString());
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
		// AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new
		// java.io.File(filename));
		return audioInputStream;
	}

	public AudioInputStream merge(List<AudioInputStream> audios) throws IOException {

		// System.out.println(filename + "------in merge and write");
		// File fileout = new File("filename");
		// if (!fileout.exists()) {
		// System.out.println("//不存在");
		// // fileout.mkdir();
		// fileout.createNewFile();
		// } else {
		// System.out.println("//目录存在");
		// }
		// 生成的新.wav路径
		// filepath = "D:\\phpStudy\\WWW\\humanSound";
		// File fileOut = new
		// File("E:/java/apache-tomcat-7.0.77/webapps/JavaWeb/music/1.wav");
		// List<String> listArr = new ArrayList<String>();
		// listArr.add("E:/java/apache-tomcat-7.0.77/webapps/data/jyutping-wong-44100-v7/aak6.wav");
		// listArr.add("E:/java/apache-tomcat-7.0.77/webapps/data/jyutping-wong-44100-v7/1.wav");
		// listArr.add("E:/java/apache-tomcat-7.0.77/webapps/data/jyutping-wong-44100-v7/ang1.wav");
		// 如果这个语音大于 2 个
		AudioInputStream audioBuild = audios.get(0);
		for (int i = 1; i < audios.size(); i++) {
			audioBuild = new AudioInputStream(new SequenceInputStream(audioBuild, audios.get(i)),
					audioBuild.getFormat(), audioBuild.getFrameLength() + audios.get(i).getFrameLength());
		}
		return audioBuild;

		// 注意 , 生成的语音要 比特率 一致,否则声音会很难听,如果要改为一直,则可以用百度音乐右上角工具来改变
	}

	public AudioInputStream read(String filename) throws UnsupportedAudioFileException, IOException {

		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename));
		// AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new
		// java.io.File(filename));
		return audioInputStream;

	}

	public Boolean write(String filename, AudioInputStream ais) throws UnsupportedAudioFileException, IOException {

		System.out.println(filename + "------in  write");
		File fileout = new File(filename);
		File fileParent = fileout.getParentFile();
		if (!fileParent.exists()) {
			System.out.println("//不存在");
			fileParent.mkdirs();
		}
		if (!fileout.exists()) {
			fileout.createNewFile();
		}
		AudioSystem.write(ais, AudioFileFormat.Type.WAVE, fileout);
		return true;

	}

}
