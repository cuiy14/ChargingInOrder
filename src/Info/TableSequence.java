package Info;

import java.util.LinkedList;

/**
 * the table to keep
 * @author Thinkpad
 *
 */
public class TableSequence {
	public static LinkedList<Snapshot> intervals;	// time interval, for one day,
	//constructor, now from a table.txt
	public TableSequence(LinkedList<Snapshot> linkedList){				
		intervals=linkedList;
	}
	
	
}
