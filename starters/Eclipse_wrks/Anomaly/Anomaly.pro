#-------------------------------------------------
#
# Project created by QtCreator 2012-11-25T01:30:06
#
#-------------------------------------------------

QT       -= core gui

TARGET = Anomaly
TEMPLATE = lib
CONFIG += staticlib

SOURCES += anomaly.cpp

HEADERS += anomaly.h
unix:!symbian {
    maemo5 {
        target.path = /opt/usr/lib
    } else {
        target.path = /usr/lib
    }
    INSTALLS += target
}
