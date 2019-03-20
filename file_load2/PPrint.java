package file_class.file_load2;

import java.util.Collection;

public class PPrint {
    public static String pformat(Collection<?> c){
        if(c.size() == 0){
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for(Object o : c){
            if(c.size() != 1){
                result.append("\n");
            }
            result.append(o);
        }
        if( c.size() != 1){
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> collection){
        System.out.println(pformat(collection));
    }

}
