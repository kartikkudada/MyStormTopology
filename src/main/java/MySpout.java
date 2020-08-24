import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class MySpout extends BaseRichSpout{
	int i =0;
	private SpoutOutputCollector collector;
	
	@Override
	public void open(Map<String, Object> conf, TopologyContext context, SpoutOutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void nextTuple() {

        this.collector.emit(new Values(i));
        i++;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		 declarer.declare(new Fields("i"));
		
	}

}
