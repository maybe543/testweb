package Application.Dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class autodialer_numberDao {
	@Resource
	private JdbcTemplate jdbctemplate;

	public Boolean create(String tableId) {

		StringBuffer sb = new StringBuffer("");
		sb.append("CREATE TABLE `" + "autodialer_number_" + tableId + "` (");
		sb.append(" `id` int(11) NOT NULL AUTO_INCREMENT,");
		sb.append("`number` VARCHAR(20) NOT NULL,");
		sb.append("`state` INT(11) NULL DEFAULT NULL,");
		sb.append("`description` VARCHAR(255) NULL DEFAULT NULL,");
		sb.append("`recycle` INT(11) NULL DEFAULT NULL,");
		sb.append("`callid` VARCHAR(255) NULL DEFAULT NULL,");
		sb.append("`calldate` DATETIME NULL DEFAULT NULL,");
		sb.append("`answerdate` DATETIME NULL DEFAULT NULL,");
		sb.append("`hangupdate` DATETIME NULL DEFAULT NULL,");
		sb.append("`bill` INT(11) NULL DEFAULT NULL,");
		sb.append("`duration` INT(11) NULL DEFAULT NULL,");
		sb.append("`hangupcause` VARCHAR(255) NULL DEFAULT NULL,");
		sb.append("`bridge_callid` VARCHAR(255) NULL DEFAULT NULL,");
		sb.append("`bridge_number` VARCHAR(20) NULL DEFAULT NULL,");
		sb.append("`bridge_calldate` DATETIME NULL DEFAULT NULL,");
		sb.append("`bridge_answerdate` DATETIME NULL DEFAULT NULL,");
		sb.append("`recordfile` VARCHAR(255) NULL DEFAULT NULL,");
		sb.append("`status` VARCHAR(255) NULL DEFAULT NULL,");
		sb.append(" PRIMARY KEY (`id`),");
		sb.append("UNIQUE INDEX `number` (`number`))");
		System.out.println(sb.toString());
		try {

			jdbctemplate.update(sb.toString());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public Boolean importphone(String tableId) {

		try {
			// jdbctemplate.execute("INSERT INTO autodialer_number_"+tableId+""
			// +
			// "(id,number,state,description,recycle,callid,calldate,answerdate,hangupdate,bill,duration,hangupcause,bridge_callid,bridge_number,bridge_calldate"
			// + "bridge_answerdate,recordfile,status)
			// VALUES('','15960285998','','','','','','','','','','','','','','','','')");
//			jdbctemplate.execute("INSERT INTO `autodialer_number_" + tableId
//					+ "`(`id`, `number`, `state`, `description`, "
//					+ "`recycle`, `callid`, `calldate`, `answerdate`, `hangupdate`, "
//					+ "`bill`, `duration`, `hangupcause`, `bridge_callid`, `bridge_number`, "
//					+ "`bridge_calldate`, `bridge_answerdate`, `recordfile`, `status`) "
//					+ "VALUES (1,'15960285998',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)");
			jdbctemplate.execute("INSERT INTO `autodialer_number_" + tableId
					+ "`(`id`, `number`, `state`, `description`, "
					+ "`recycle`, `callid`, `calldate`, `answerdate`, `hangupdate`, "
					+ "`bill`, `duration`, `hangupcause`, `bridge_callid`, `bridge_number`, "
					+ "`bridge_calldate`, `bridge_answerdate`, `recordfile`, `status`) "
					+ "VALUES (2,'13599039564',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public Boolean drop(String tableId) {
		StringBuffer sb = new StringBuffer("");
		sb.append("DROP TABLE `" + "autodialer_number_" + tableId);

		try {
			jdbctemplate.execute(sb.toString());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	// CREATE TABLE `autodialer_number_1` (
	// `id` INT(11) NOT NULL AUTO_INCREMENT,
	// `number` VARCHAR(20) NOT NULL,
	// `state` INT(11) NULL DEFAULT NULL,
	// `description` VARCHAR(255) NULL DEFAULT NULL,
	// `recycle` INT(11) NULL DEFAULT NULL,
	// `callid` VARCHAR(255) NULL DEFAULT NULL,
	// `calldate` DATETIME NULL DEFAULT NULL,
	// `answerdate` DATETIME NULL DEFAULT NULL,
	// `hangupdate` DATETIME NULL DEFAULT NULL,
	// `bill` INT(11) NULL DEFAULT NULL,
	// `duration` INT(11) NULL DEFAULT NULL,
	// `hangupcause` VARCHAR(255) NULL DEFAULT NULL,
	// `bridge_callid` VARCHAR(255) NULL DEFAULT NULL,
	// `bridge_number` VARCHAR(20) NULL DEFAULT NULL,
	// `bridge_calldate` DATETIME NULL DEFAULT NULL,
	// `bridge_answerdate` DATETIME NULL DEFAULT NULL,
	// `recordfile` VARCHAR(255) NULL DEFAULT NULL,
	// `status` VARCHAR(255) NULL DEFAULT NULL,
	// PRIMARY KEY (`id`),
	// UNIQUE INDEX `number` (`number`)
	// )
}
