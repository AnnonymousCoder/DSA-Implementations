
CC   ?= gcc.exe
MAKE ?= mingw32-make.exe
PROJECT_NAME ?= default # Change this to the desired src file name
EXT 		 ?= .exe

WORKING_DIR  ?= .
INCLUDE_PATH = $(WORKING_DIR)/inc
SRC_PATH 	 = $(WORKING_DIR)/src
OBJ_PATH 	 = $(WORKING_DIR)/obj
BIN_PATH 	 = $(WORKING_DIR)/bin


SRC ?= $(SRC_PATH)/$(PROJECT_NAME).c
OBJS = $(OBJ_PATH)/$(PROJECT_NAME).o


PROG_NAME = $(BIN_PATH)\$(PROJECT_NAME)$(EXT)

CFLAGS = -Wall -Wextra -Wpedantic -std=c99 -Wno-missing-braces 

.PHONY: all clean

all:
	$(MAKE) $(PROG_NAME)
	
run:
ifeq ($(OS),Windows_NT)
	.\$(subst /,\,$(PROG_NAME))	
else
	.\$(PROG_NAME)
endif

makerun: all run

$(PROG_NAME): $(OBJS)
	$(CC) -o $@ $(OBJS) $(CFLAGS) -I $(INCLUDE_PATH)
	
$(OBJ_PATH)/$(PROJECT_NAME).o: $(SRC_PATH)/$(PROJECT_NAME).c
	$(CC) -c $< -o $@ $(CFLAGS) -I $(INCLUDE_PATH)


clean:
ifeq ($(OS),Windows_NT)
	cmd.exe /C del "$(subst /,\,$(OBJ_PATH))\$(PROJECT_NAME).o"
	cmd.exe /C del "$(subst /,\,$(BIN_PATH))\$(PROJECT_NAME).exe"
else
	rm "$(OBJ_PATH)"/$(PROJECT_NAME).o
	rm "$(BIN_PATH)"/$(PROJECT_NAME).exe 
endif