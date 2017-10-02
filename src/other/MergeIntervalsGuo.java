package other;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by FYG on 17/10/1.
 */
public class MergeIntervalsGuo {
    public ArrayList<OutType> countProcess(int[][] input) {
        Point[] points = new Point[input.length * 2];
        for (int i = 0; i < input.length; i++) {
            points[2 * i] = new Point(input[i][0], 0);
            points[2 * i + 1] = new Point(input[i][1], 1);
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.pos - o2.pos;
            }
        });

//        for (int i = 0; i < points.length; i++) {
//            System.out.println(points[i].pos);
//        }

        int count = 0;
        int start = 0;
        int end = points[0].pos;
        ArrayList<OutType> result = new ArrayList<>();
        for (int i = 0; i < points.length; ) {
            int temp = points[i].pos;
            //System.out.println(temp);
            int j = i;
            while (j < points.length && temp == points[j].pos) {
                //if (j != i) {
                    if (points[j].status == 0) {
                        count++;
                    } else {
                        count--;
                    }
                //}
                j++;
            }
            if (j == points.length) break;
            i = j;
            end = points[i].pos;
            result.add(new OutType(start, end, count));
            start = end;
        }

        return result;

    }
    public static void main(String[] args) throws FileNotFoundException{
        MergeIntervalsGuo test = new MergeIntervalsGuo();
        //int[][] in = {{0, 15074}, {5, 15593}, {6, 18111}, {6, 15171}, {6, 15923}, {7, 15434}, {7, 15442}, {7, 15473}, {8, 15340}, {8, 15340}, {8, 15479}, {9, 15980}, {9, 14706}, {9, 26183}, {10, 26893}, {11, 18755}, {11, 27917}, {12, 16380}, {12, 15926}, {12, 27141}, {13, 26185}, {13, 27049}, {13, 28274}, {14, 26702}, {14, 26113}, {14, 25814}, {41784, 57078}, {41794, 54214}, {41794, 55445}, {41795, 56121}, {41796, 53516}, {41796, 57173}, {41796, 51863}, {65949, 75690}, {65958, 75606}, {65959, 75243}, {65959, 75251}, {65960, 82951}, {90722, 98026}, {90728, 105590}, {113394, 120601}, {113400, 127739}};
        int[][] in = {{176, 2596}, {126, 4691}, {373, 4889}, {100, 5303}, {184, 5330}, {205, 5385}, {124, 5440}, {130, 5599}, {588, 5737}, {217, 5855}, {659, 6169}, {205, 6431}, {373, 7855}, {592, 7971}, {4405, 8072}, {0, 8119}, {623, 8133}, {7161, 9478}, {7381, 9825}, {6914, 11801}, {6615, 12474}, {7584, 14506}, {8016, 79906}, {9628, 79935}, {10957, 81671}, {8924, 82032}, {8955, 83324}, {8677, 84337}, {7775, 89558}, {8471, 89960}, {10648, 90142}, {10795, 90224}, {12890, 90308}, {12292, 94634}, {10966, 95630}, {14709, 99775}, {17331, 100541}, {15463, 103581}, {84004, 150868}, {85288, 151187}, {83319, 152442}, {84732, 159254}, {86332, 162020}, {92949, 165914}, {85141, 166198}, {93136, 171829}, {92021, 177530}, {98396, 179311}, {93222, 179694}, {103338, 179879}, {91767, 180950}, {97210, 181694}, {106536, 182995}, {101741, 187230}, {154075, 217906}, {152880, 220286}, {162218, 231752}, {155304, 233059}, {164740, 240471}, {169371, 241999}, {174836, 245630}, {168500, 248473}, {182692, 253441}, {180279, 254633}, {185481, 255837}, {181923, 256125}, {184680, 264679}, {183847, 265416}, {182348, 267373}, {190257, 271088}, {220402, 283346}, {223378, 284571}, {287325, 301175}, {287051, 302233}, {286726, 302684}, {304650, 321795}, {304632, 322056}, {304634, 322185}, {324143, 337298}, {324428, 338833}, {324237, 339567}, {341380, 342756}, {344700, 346468}};
        ArrayList<OutType> result = test.countProcess(in);
        PrintWriter pw = new PrintWriter(new File("test.csv"));
        StringBuilder sb = new StringBuilder();

//        sb.append("Time");
//        sb.append(",");
//        sb.append("Number of tasks");
//        sb.append("\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i).start + "~" + result.get(i).end);
            sb.append(",");
            sb.append(result.get(i).counter);
            sb.append("\n");
            System.out.println("[ " + result.get(i).start + ", " + result.get(i).end + " ]" + "  " + result.get(i).counter);
        }

        pw.write(sb.toString());
        pw.close();
    }


}

class OutType {
    int start;
    int end;
    int counter;
    OutType (int start, int end, int counter) {
        this.start = start;
        this.end = end;
        this.counter = counter;
    }
}

class Point {
    int pos;
    int status;
    Point (int pos, int status) {
        this.pos = pos;
        this.status = status;
    }
}
