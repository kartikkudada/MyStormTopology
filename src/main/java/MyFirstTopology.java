import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class MyFirstTopology {

	public static void main(String[] args) throws Exception {

		TopologyBuilder builder = new TopologyBuilder();
		
		builder.setSpout("myspout", new MySpout(), 1);
		builder.setBolt("mybolt", new MyBolt(),1).shuffleGrouping("myspout");
		
		Config config = new Config();
		LocalCluster cluster = new LocalCluster();
		try {
			cluster.submitTopology("myfirsttopology", config, builder.createTopology());
			Thread.sleep(20000);
			cluster.killTopology("myfirsttopology");
			cluster.shutdown();
			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
	}

}
