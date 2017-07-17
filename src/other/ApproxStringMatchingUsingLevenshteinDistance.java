package other;

/**
 * Created by FYG on 17/7/17.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ApproxStringMatchingUsingLevenshteinDistance
{
    public static int distance(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++)
        {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++)
            {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
                        a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String text = "\"Child is either closed or not found. objectId = Disbursement/SettlementId:634ec52f-7259-3d06-8d7a-68c7888f1a89, childId = WorkItemIdentifier[SellerEventAggregator,Disbursement/SettlementId:634ec52f-7259-3d06-8d7a-68c7888f1a89::V2,NotifyDownstream,28a74b60-c9c7-461c-9d2d-e826f2fbc21a]\",";
        System.out.println("System genetated string is: \n'" + text + "'");
        System.out.println("Enter the keyword to search: ");
        String keyword = sc.nextLine();
        String[] data = text.split(" ");
        List<Integer> dist = new ArrayList<Integer>();
        for (int i = 0; i < data.length; i++)
        {
            dist.add(distance(data[i], keyword));
        }
        Collections.sort(dist);
        System.out.print("Did you mean: ");
        for (int i = 0; i < data.length; i++)
        {
            if (distance(data[i], keyword) == dist.get(0))
            {
                System.out.print(data[i] + " ");
            }
        }
        sc.close();
    }
}

