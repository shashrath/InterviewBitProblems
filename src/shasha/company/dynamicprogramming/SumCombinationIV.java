package shasha.company.dynamicprogramming;

import java.util.ArrayList;

public class SumCombinationIV {
    public static void main(String[] args) {
        SumCombinationIV sum = new SumCombinationIV();
        int nums[] = {1,2,3};
        int result = sum.combinationSum4(nums,32);
        System.out.println(result);
        String s = "[{\"eventIdentification\":{\"identified_event_version\":1,\"identified_event_Id\":\"EVT000000858\",\"identified_event_name\":\"EOMSYS Completed Notification to Query LRM for IMSI Details\"},\"jpId\":\"JP000000279\",\"eventId\":\"EVT000000858\",\"eventPayLoad\":{\"extract_timestamp\":1618812930227,\"payload\":{\"data\":{\"elementId\":\"59DFEFEC3B25425A81BC178173DE00A9\",\"resourceId\":\"CBA66923164146B9B467E31902DAB2C4\",\"systemId\":\"B2C-Vlocity\",\"profileId\":\"8189069DE1A045419BA7F1427DAA56491618812912\",\"externalOrderId\":\"D21191608116002\",\"notificationType\":\"ActivityCompletedNotification\",\"elementName\":\"Query LRM for IMSI Details\"},\"eventKey\":\"Execution.EOMSYS.activity-statusChange.event.aomd\",\"correlationId\":\"46a49fcb-4d29-8771-1e8c-8f04293e8f4f\",\"resourceURI\":\"https://eomsys-sfo.sit.cloud.corp.telstra.com:443/orderorchestration/rest/ordermanager/orders/CBA66923164146B9B467E31902DAB2C4\",\"routingKey\":\"Execution.EOMSYS.activity-statusChange.event.aomd\",\"timestamp\":\"2021-04-19T06:15:25.000Z\"},\"uuid\":\"1618812930227_a425105c-a0d6-11eb-b3a2-952f7059e396\",\"timestamp\":\"2021-04-19T06:15:25.000Z\"},\"EventAct\":\"EVENT\",\"condition_type\":\"RES\",\"eventEnrichment\":{\"enrichmenterrors\":[],\"external\":[],\"retryStatus\":\"SUCCESS\",\"retryErrors\":[],\"dataenrichment\":{}},\"eventUUID\":\"1618812930227_a425105c-a0d6-11eb-b3a2-952f7059e396\",\"episodeID\":\"LK191618812760937\",\"activityDetails\":{\"activityId\":\"ACT000000101\",\"endEvent\":\"true\",\"ei\":\"LK191618812760937\",\"startEvent\":\"false\",\"activityName\":\"Query LRM for IMSI Details\",\"rowKey\":\"LK191618812760937_1618812930227_a425105c-a0d6-11eb-b3a2-952f7059e396\"}}]";
    }

    public int combinationSum4(int[] nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        sumCombinationUtil(nums,0,target,result);
        return result.get(0);

    }

    public void sumCombinationUtil(int []nums, Integer sum, Integer target, ArrayList<Integer> result){
        if(sum > target)
            return ;
        if(sum.equals(target)){
            result.set(0,result.get(0)+1);
            return;
        }
        for(int i=0;i< nums.length;i++){
            sumCombinationUtil(nums, sum+ nums[i], target, result);
        }
    }
}
