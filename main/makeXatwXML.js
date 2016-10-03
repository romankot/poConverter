/**
 * Created by Roman on 9/22/2016.
 */

//#include "eventJson199A0.txt"
#include "event.txt"
var returnedObject = null;

function lookInJsonEvent(childrenList, keyToFind) {
    for (var i=0; i < childrenList.length; i++) {
        var child = childrenList[i];
        //_printf("child " + i + child.Name);
        if (child.Name == keyToFind) {
            _printf("Found key " + child.Name + "---" + child.Parent + "\r\n");
            returnedObject = child;
            return true;
        }
        if (lookInJsonEvent(child.ChildrenList, keyToFind)) {
           return true;
        }
    }
}

var fp = _file.fopen(_job.command.in, "r");		// This opens the data file specified on the Merge command line
if (!fp)_message("File open error");

var xml = new XmlFile("./outforMerge.xml");
var sRec;
var obj;
var names = ["key", "value"];
var eventName = null;

while (sRec = fp.fgets()) {
    if (sRec.length < 5 || (sRec.lastIndexOf('*', 0) === 0)) continue;
    obj = _parser.delimited(sRec, names, '\t');
    if (obj) {
        if (obj.key.lastIndexOf('BEGIN', 0) === 0 ) {
            eventName = obj.key.substring(5);  // from 5 pos to string end
            xml.tag(eventName);
            continue;
        }
        //lookInJsonEvent(data, obj.key);
        _logf("looking for " + obj.key)
        lookInJsonEvent(data.ChildrenList, obj.key);
        if ((eventName != null) && (returnedObject != null)) {
            if (returnedObject.ChildrenList.length > 0 ) {
                //CREATE NODE
                xml.tag(returnedObject.Parent);
            } else {
                // ADD NODE
                xml[obj.key] = obj.value;
            }
        }
    }
}

fp.fclose();
xml.close();
