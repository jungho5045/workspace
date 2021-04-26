package me.whiteship;

public class Moim {

    int maxNumberOfAttendees;   // 최대 참가자

    int numberOfEnrollment;     // 현재까지 신청

    public boolean isEnrollmentFull(){  // 현재 신청이 꽉 찼는지
        if(maxNumberOfAttendees == 0){
            return false;
        }

        if(numberOfEnrollment < maxNumberOfAttendees){
            return false;
        }

        return true;
    }

}