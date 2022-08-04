package com.example.demo.converter;

import com.example.demo.constant.RequestStatus;
import com.example.demo.constant.RequestType;
import com.example.demo.domain.Request;
import com.example.demo.request.Request.CreateLeaveRequest;
import com.example.demo.request.Request.CreateSoonLateRequest;
import com.example.demo.response.ListRequestResponse;
import com.example.demo.response.RequestResponse;

import java.util.Calendar;

public class RequestConverter {

    public static Request convertRequestLeaveToOffResponse(String userId, CreateLeaveRequest createLeaveRequest) {
        return Request.builder()
                .requestStatus(RequestStatus.PENDING)
                .requestTitle(createLeaveRequest.getOffType().toString())
                .receiverEmail(createLeaveRequest.getReceiverEmail())
                .createTime(System.currentTimeMillis())
                .message(createLeaveRequest.getMessage())
                .dayRequest(createLeaveRequest.getDateBegin() + " - " + createLeaveRequest.getDateEnd())
                .numDayOff(DateConvert.calculateDayOff(createLeaveRequest))
                .requestType(RequestType.OFF)
                .userId(userId)
                .yearRequest(DateConvert.getCurrentYear())
                .build();
    }

    public static RequestResponse convertReponseFromOff(Request request, double remain) {
        return RequestResponse.builder()
                .id(request.getId())
                .requestTitle(request.getRequestTitle())
                .requestStatus(request.getRequestStatus())
                .timeRequest(request.getDayRequest())
                .timeNeed(RequestConverter.getTimeNeed(request))
                .timeRemain(remain + "days in this year")
                .build();
    }

    public static Request convertRequestLateSoonToRequest(String userId, CreateSoonLateRequest createSoonLateRequest) {
        return Request.builder()
                .requestStatus(RequestStatus.PENDING)
                .requestTitle(createSoonLateRequest.getLateOrSoon().toString())
                .receiverEmail(createSoonLateRequest.getReceiverEmail())
                .createTime(System.currentTimeMillis())
                .message(createSoonLateRequest.getMessage())
                .dayRequest(createSoonLateRequest.getShift().toString() + " - " + createSoonLateRequest.getDayRequest())
                .timeNeed(createSoonLateRequest.getTimeLateOrSoon())
                .requestType(RequestType.LATE_SOON)
                .userId(userId)
                .timeRemainInWeek(1)
                .yearRequest(DateConvert.getCurrentYear())
                .build();
    }

    public static Request convertRequestLateSoonToRequest(String userId, CreateSoonLateRequest createSoonLateRequest,
                                                          String lastRequestDay, int oldRemain) {
        return Request.builder()
                .requestStatus(RequestStatus.PENDING)
                .requestTitle(createSoonLateRequest.getLateOrSoon().toString())
                .receiverEmail(createSoonLateRequest.getReceiverEmail())
                .createTime(System.currentTimeMillis())
                .message(createSoonLateRequest.getMessage())
                .dayRequest(createSoonLateRequest.getShift().toString() + " - " + createSoonLateRequest.getDayRequest())
                .timeNeed(createSoonLateRequest.getTimeLateOrSoon())
                .requestType(RequestType.LATE_SOON)
                .userId(userId)
                .timeRemainInWeek(countTimeRemaining(createSoonLateRequest.getDayRequest(), lastRequestDay, oldRemain))
                .yearRequest(DateConvert.getCurrentYear())
                .build();
    }

    public static int countTimeRemaining(String dayNewRequest, String dayOldRequest, int oldRemain){
        String[] split = dayOldRequest.split(" - ");
        long millisNew = DateConvert.fromStringToMillis(dayNewRequest);
        long millisOld = DateConvert.fromStringToMillis(dayOldRequest);
        Calendar calendarNew = Calendar.getInstance();
        calendarNew.setTimeInMillis(millisNew);
        Calendar calendarOld = Calendar.getInstance();
        calendarOld.setTimeInMillis(millisOld);
        int week1 = calendarNew.get(Calendar.WEEK_OF_YEAR);
        int week2 = calendarOld.get(Calendar.WEEK_OF_YEAR);
        if (week1 == week2) {
                return oldRemain - 1;
        }
        return 1;
    }

    public static String getTimeNeed(Request request) {
        if (request.getRequestType().equals(RequestType.OFF)) {
            return request.getNumDayOff() + " ngày ";
        }
        return request.getTimeNeed();
    }

    public static RequestResponse toResponseFromLate(Request request, int remain) {
        return RequestResponse.builder()
                .id(request.getId())
                .requestTitle(request.getRequestTitle())
                .requestStatus(request.getRequestStatus())
                .timeRequest(request.getDayRequest())
                .timeNeed(RequestConverter.getTimeNeed(request))
                .build();
    }

    public static ListRequestResponse toResponse(Request request) {
        return ListRequestResponse.builder()
                .id(request.getId())
                .requestTitle(request.getRequestTitle())
                .requestStatus(request.getRequestStatus())
                .timeRequest(request.getDayRequest())
                .timeNeed(RequestConverter.getTimeNeed(request))
                .build();
    }
}
