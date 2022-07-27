package com.teamsfinder.userreadservice.user.exception;

import java.time.LocalDateTime;

record ErrorResponse(
        String httpStatus,
        String message,
        LocalDateTime localDateTime) {

}
