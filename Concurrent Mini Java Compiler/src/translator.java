DataFrag(
	.data
NQueens_vtable:
	.word NQueens.main

)
DataFrag(
	.data
Queens2_vtable:
	.word Queens2.init
	.word Queens2.run
	.word Queens2.printboard

)
DataFrag(
	.data
L0:	.asciiz	"Number of queens? "
)
ProcFrag(
MipsFrame(
main:
Formals(InReg(t32)
	InReg(t33)
	)
Actuals(InReg(t4)
	InReg(t5)
	)
BadPtr(_BADPTR)
BadSub(_BADSUB)
)
SEQ(
 SEQ(
  SEQ(
   SEQ(
    SEQ(
     SEQ(
      SEQ(
       MOVE(
        TEMP(t34)
        CONST(0))
       MOVE(
        TEMP(t35)
        CONST(0)))
      MOVE(
       TEMP(t36)
       CONST(0)))
     EXP(
      CALL(
       NAME(_print)
       NAME(L0)
      )))
    MOVE(
     TEMP(t34)
     CALL(
      NAME(_readint)
     )))
   MOVE(
    TEMP(t36)
    ESEQ(
     SEQ(
      MOVE(
       TEMP(t37)
       CALL(
        NAME(_new)
        CONST(5)
        NAME(Queens2_vtable)
       ))
      SEQ(
       CJUMP(EQ
        TEMP(t37)
        CONST(0)
        _BADPTR L1)
       LABEL(L1)))
     CALL(
      MEM(
       BINOP(PLUS
        MEM(
         BINOP(PLUS
          TEMP(t37)
          CONST(-4)))
        CONST(0)))
      TEMP(t37)
      TEMP(t34)
     ))))
  MOVE(
   TEMP(t35)
   ESEQ(
    SEQ(
     MOVE(
      TEMP(t38)
      TEMP(t36))
     SEQ(
      CJUMP(EQ
       TEMP(t38)
       CONST(0)
       _BADPTR L2)
      LABEL(L2)))
    CALL(
     MEM(
      BINOP(PLUS
       MEM(
        BINOP(PLUS
         TEMP(t38)
         CONST(-4)))
       CONST(4)))
     TEMP(t38)
     CONST(0)
    ))))
 MOVE(
  TEMP(t2)
  CONST(0)))
)
ProcFrag(
MipsFrame(
Queens2.init:
Formals(InReg(t39)
	InReg(t40)
	)
Actuals(InReg(t4)
	InReg(t5)
	)
BadPtr(_BADPTR)
BadSub(_BADSUB)
)
SEQ(
 SEQ(
  SEQ(
   SEQ(
    SEQ(
     MOVE(
      ESEQ(
       SEQ(
        MOVE(
         TEMP(t41)
         TEMP(t39))
        CJUMP(EQ
         TEMP(t41)
         CONST(0)
         _BADPTR L3))
       ESEQ(
        LABEL(L3)
        MEM(
         BINOP(PLUS
          TEMP(t41)
          CONST(0)))))
      TEMP(t40))
     MOVE(
      ESEQ(
       SEQ(
        MOVE(
         TEMP(t42)
         TEMP(t39))
        CJUMP(EQ
         TEMP(t42)
         CONST(0)
         _BADPTR L4))
       ESEQ(
        LABEL(L4)
        MEM(
         BINOP(PLUS
          TEMP(t42)
          CONST(4)))))
      ESEQ(
       MOVE(
        TEMP(t43)
        TEMP(t40))
       CALL(
        NAME(_new)
        TEMP(t43)
        TEMP(t43)
       ))))
    MOVE(
     ESEQ(
      SEQ(
       MOVE(
        TEMP(t44)
        TEMP(t39))
       CJUMP(EQ
        TEMP(t44)
        CONST(0)
        _BADPTR L5))
      ESEQ(
       LABEL(L5)
       MEM(
        BINOP(PLUS
         TEMP(t44)
         CONST(8)))))
     ESEQ(
      MOVE(
       TEMP(t45)
       TEMP(t40))
      CALL(
       NAME(_new)
       TEMP(t45)
       TEMP(t45)
      ))))
   MOVE(
    ESEQ(
     SEQ(
      MOVE(
       TEMP(t46)
       TEMP(t39))
      CJUMP(EQ
       TEMP(t46)
       CONST(0)
       _BADPTR L6))
     ESEQ(
      LABEL(L6)
      MEM(
       BINOP(PLUS
        TEMP(t46)
        CONST(12)))))
    ESEQ(
     MOVE(
      TEMP(t47)
      BINOP(MINUS
       BINOP(PLUS
        TEMP(t40)
        TEMP(t40))
       CONST(1)))
     CALL(
      NAME(_new)
      TEMP(t47)
      TEMP(t47)
     ))))
  MOVE(
   ESEQ(
    SEQ(
     MOVE(
      TEMP(t48)
      TEMP(t39))
     CJUMP(EQ
      TEMP(t48)
      CONST(0)
      _BADPTR L7))
    ESEQ(
     LABEL(L7)
     MEM(
      BINOP(PLUS
       TEMP(t48)
       CONST(16)))))
   ESEQ(
    MOVE(
     TEMP(t49)
     BINOP(MINUS
      BINOP(PLUS
       TEMP(t40)
       TEMP(t40))
      CONST(1)))
    CALL(
     NAME(_new)
     TEMP(t49)
     TEMP(t49)
    ))))
 MOVE(
  TEMP(t2)
  TEMP(t39)))
)
ProcFrag(
MipsFrame(
Queens2.run:
Formals(InReg(t50)
	InReg(t51)
	)
Actuals(InReg(t4)
	InReg(t5)
	)
BadPtr(_BADPTR)
BadSub(_BADSUB)
)
SEQ(
 SEQ(
  SEQ(
   MOVE(
    TEMP(t52)
    CONST(0))
   MOVE(
    TEMP(t53)
    CONST(0)))
  SEQ(
   SEQ(
    CJUMP(EQ
     TEMP(t51)
     ESEQ(
      SEQ(
       MOVE(
        TEMP(t54)
        TEMP(t50))
       CJUMP(EQ
        TEMP(t54)
        CONST(0)
        _BADPTR L8))
      ESEQ(
       LABEL(L8)
       MEM(
        BINOP(PLUS
         TEMP(t54)
         CONST(0)))))
     L62 L63)
    SEQ(
     SEQ(
      SEQ(
       LABEL(L62)
       MOVE(
        TEMP(t52)
        ESEQ(
         SEQ(
          MOVE(
           TEMP(t55)
           TEMP(t50))
          SEQ(
           CJUMP(EQ
            TEMP(t55)
            CONST(0)
            _BADPTR L9)
           LABEL(L9)))
         CALL(
          MEM(
           BINOP(PLUS
            MEM(
             BINOP(PLUS
              TEMP(t55)
              CONST(-4)))
            CONST(8)))
          TEMP(t55)
         ))))
      JUMP(
       NAME(L64)))
     SEQ(
      SEQ(
       LABEL(L63)
       SEQ(
        MOVE(
         TEMP(t53)
         CONST(0))
        SEQ(
         SEQ(
          SEQ(
           LABEL(L60)
           CJUMP(LT
            TEMP(t53)
            ESEQ(
             SEQ(
              MOVE(
               TEMP(t56)
               TEMP(t50))
              CJUMP(EQ
               TEMP(t56)
               CONST(0)
               _BADPTR L10))
             ESEQ(
              LABEL(L10)
              MEM(
               BINOP(PLUS
                TEMP(t56)
                CONST(0)))))
            L61 L59))
          SEQ(
           SEQ(
            LABEL(L61)
            SEQ(
             SEQ(
              SEQ(
               SEQ(
                SEQ(
                 CJUMP(EQ
                  ESEQ(
                   SEQ(
                    MOVE(
                     TEMP(t58)
                     ESEQ(
                      SEQ(
                       MOVE(
                        TEMP(t57)
                        TEMP(t50))
                       CJUMP(EQ
                        TEMP(t57)
                        CONST(0)
                        _BADPTR L11))
                      ESEQ(
                       LABEL(L11)
                       MEM(
                        BINOP(PLUS
                         TEMP(t57)
                         CONST(4))))))
                    SEQ(
                     MOVE(
                      TEMP(t59)
                      TEMP(t53))
                     SEQ(
                      CJUMP(EQ
                       TEMP(t58)
                       CONST(0)
                       _BADPTR L12)
                      SEQ(
                       LABEL(L12)
                       SEQ(
                        CJUMP(LT
                         TEMP(t59)
                         CONST(0)
                         _BADSUB L13)
                        SEQ(
                         LABEL(L13)
                         CJUMP(GE
                          TEMP(t59)
                          MEM(
                           BINOP(PLUS
                            TEMP(t58)
                            CONST(-4)))
                          _BADSUB L14)))))))
                   ESEQ(
                    LABEL(L14)
                    MEM(
                     BINOP(PLUS
                      TEMP(t58)
                      BINOP(MUL
                       TEMP(t59)
                       CONST(4))))))
                  CONST(0)
                  L58 L56)
                 SEQ(
                  LABEL(L58)
                  CJUMP(EQ
                   ESEQ(
                    SEQ(
                     MOVE(
                      TEMP(t61)
                      ESEQ(
                       SEQ(
                        MOVE(
                         TEMP(t60)
                         TEMP(t50))
                        CJUMP(EQ
                         TEMP(t60)
                         CONST(0)
                         _BADPTR L15))
                       ESEQ(
                        LABEL(L15)
                        MEM(
                         BINOP(PLUS
                          TEMP(t60)
                          CONST(12))))))
                     SEQ(
                      MOVE(
                       TEMP(t62)
                       BINOP(PLUS
                        TEMP(t53)
                        TEMP(t51)))
                      SEQ(
                       CJUMP(EQ
                        TEMP(t61)
                        CONST(0)
                        _BADPTR L16)
                       SEQ(
                        LABEL(L16)
                        SEQ(
                         CJUMP(LT
                          TEMP(t62)
                          CONST(0)
                          _BADSUB L17)
                         SEQ(
                          LABEL(L17)
                          CJUMP(GE
                           TEMP(t62)
                           MEM(
                            BINOP(PLUS
                             TEMP(t61)
                             CONST(-4)))
                           _BADSUB L18)))))))
                    ESEQ(
                     LABEL(L18)
                     MEM(
                      BINOP(PLUS
                       TEMP(t61)
                       BINOP(MUL
                        TEMP(t62)
                        CONST(4))))))
                   CONST(0)
                   L57 L56)))
                SEQ(
                 LABEL(L57)
                 CJUMP(EQ
                  ESEQ(
                   SEQ(
                    MOVE(
                     TEMP(t65)
                     ESEQ(
                      SEQ(
                       MOVE(
                        TEMP(t63)
                        TEMP(t50))
                       CJUMP(EQ
                        TEMP(t63)
                        CONST(0)
                        _BADPTR L19))
                      ESEQ(
                       LABEL(L19)
                       MEM(
                        BINOP(PLUS
                         TEMP(t63)
                         CONST(16))))))
                    SEQ(
                     MOVE(
                      TEMP(t66)
                      BINOP(MINUS
                       BINOP(MINUS
                        BINOP(PLUS
                         TEMP(t53)
                         ESEQ(
                          SEQ(
                           MOVE(
                            TEMP(t64)
                            TEMP(t50))
                           CJUMP(EQ
                            TEMP(t64)
                            CONST(0)
                            _BADPTR L20))
                          ESEQ(
                           LABEL(L20)
                           MEM(
                            BINOP(PLUS
                             TEMP(t64)
                             CONST(0))))))
                        CONST(1))
                       TEMP(t51)))
                     SEQ(
                      CJUMP(EQ
                       TEMP(t65)
                       CONST(0)
                       _BADPTR L21)
                      SEQ(
                       LABEL(L21)
                       SEQ(
                        CJUMP(LT
                         TEMP(t66)
                         CONST(0)
                         _BADSUB L22)
                        SEQ(
                         LABEL(L22)
                         CJUMP(GE
                          TEMP(t66)
                          MEM(
                           BINOP(PLUS
                            TEMP(t65)
                            CONST(-4)))
                          _BADSUB L23)))))))
                   ESEQ(
                    LABEL(L23)
                    MEM(
                     BINOP(PLUS
                      TEMP(t65)
                      BINOP(MUL
                       TEMP(t66)
                       CONST(4))))))
                  CONST(0)
                  L55 L56)))
               SEQ(
                SEQ(
                 LABEL(L55)
                 SEQ(
                  SEQ(
                   SEQ(
                    SEQ(
                     SEQ(
                      SEQ(
                       SEQ(
                        MOVE(
                         ESEQ(
                          SEQ(
                           MOVE(
                            TEMP(t68)
                            ESEQ(
                             SEQ(
                              MOVE(
                               TEMP(t67)
                               TEMP(t50))
                              CJUMP(EQ
                               TEMP(t67)
                               CONST(0)
                               _BADPTR L24))
                             ESEQ(
                              LABEL(L24)
                              MEM(
                               BINOP(PLUS
                                TEMP(t67)
                                CONST(4))))))
                           SEQ(
                            MOVE(
                             TEMP(t69)
                             TEMP(t53))
                            SEQ(
                             CJUMP(EQ
                              TEMP(t68)
                              CONST(0)
                              _BADPTR L25)
                             SEQ(
                              LABEL(L25)
                              SEQ(
                               CJUMP(LT
                                TEMP(t69)
                                CONST(0)
                                _BADSUB L26)
                               SEQ(
                                LABEL(L26)
                                CJUMP(GE
                                 TEMP(t69)
                                 MEM(
                                  BINOP(PLUS
                                   TEMP(t68)
                                   CONST(-4)))
                                 _BADSUB L27)))))))
                          ESEQ(
                           LABEL(L27)
                           MEM(
                            BINOP(PLUS
                             TEMP(t68)
                             BINOP(MUL
                              TEMP(t69)
                              CONST(4))))))
                         CONST(1))
                        MOVE(
                         ESEQ(
                          SEQ(
                           MOVE(
                            TEMP(t71)
                            ESEQ(
                             SEQ(
                              MOVE(
                               TEMP(t70)
                               TEMP(t50))
                              CJUMP(EQ
                               TEMP(t70)
                               CONST(0)
                               _BADPTR L28))
                             ESEQ(
                              LABEL(L28)
                              MEM(
                               BINOP(PLUS
                                TEMP(t70)
                                CONST(12))))))
                           SEQ(
                            MOVE(
                             TEMP(t72)
                             BINOP(PLUS
                              TEMP(t53)
                              TEMP(t51)))
                            SEQ(
                             CJUMP(EQ
                              TEMP(t71)
                              CONST(0)
                              _BADPTR L29)
                             SEQ(
                              LABEL(L29)
                              SEQ(
                               CJUMP(LT
                                TEMP(t72)
                                CONST(0)
                                _BADSUB L30)
                               SEQ(
                                LABEL(L30)
                                CJUMP(GE
                                 TEMP(t72)
                                 MEM(
                                  BINOP(PLUS
                                   TEMP(t71)
                                   CONST(-4)))
                                 _BADSUB L31)))))))
                          ESEQ(
                           LABEL(L31)
                           MEM(
                            BINOP(PLUS
                             TEMP(t71)
                             BINOP(MUL
                              TEMP(t72)
                              CONST(4))))))
                         CONST(1)))
                       MOVE(
                        ESEQ(
                         SEQ(
                          MOVE(
                           TEMP(t75)
                           ESEQ(
                            SEQ(
                             MOVE(
                              TEMP(t73)
                              TEMP(t50))
                             CJUMP(EQ
                              TEMP(t73)
                              CONST(0)
                              _BADPTR L32))
                            ESEQ(
                             LABEL(L32)
                             MEM(
                              BINOP(PLUS
                               TEMP(t73)
                               CONST(16))))))
                          SEQ(
                           MOVE(
                            TEMP(t76)
                            BINOP(MINUS
                             BINOP(MINUS
                              BINOP(PLUS
                               TEMP(t53)
                               ESEQ(
                                SEQ(
                                 MOVE(
                                  TEMP(t74)
                                  TEMP(t50))
                                 CJUMP(EQ
                                  TEMP(t74)
                                  CONST(0)
                                  _BADPTR L33))
                                ESEQ(
                                 LABEL(L33)
                                 MEM(
                                  BINOP(PLUS
                                   TEMP(t74)
                                   CONST(0))))))
                              CONST(1))
                             TEMP(t51)))
                           SEQ(
                            CJUMP(EQ
                             TEMP(t75)
                             CONST(0)
                             _BADPTR L34)
                            SEQ(
                             LABEL(L34)
                             SEQ(
                              CJUMP(LT
                               TEMP(t76)
                               CONST(0)
                               _BADSUB L35)
                              SEQ(
                               LABEL(L35)
                               CJUMP(GE
                                TEMP(t76)
                                MEM(
                                 BINOP(PLUS
                                  TEMP(t75)
                                  CONST(-4)))
                                _BADSUB L36)))))))
                         ESEQ(
                          LABEL(L36)
                          MEM(
                           BINOP(PLUS
                            TEMP(t75)
                            BINOP(MUL
                             TEMP(t76)
                             CONST(4))))))
                        CONST(1)))
                      MOVE(
                       ESEQ(
                        SEQ(
                         MOVE(
                          TEMP(t78)
                          ESEQ(
                           SEQ(
                            MOVE(
                             TEMP(t77)
                             TEMP(t50))
                            CJUMP(EQ
                             TEMP(t77)
                             CONST(0)
                             _BADPTR L37))
                           ESEQ(
                            LABEL(L37)
                            MEM(
                             BINOP(PLUS
                              TEMP(t77)
                              CONST(8))))))
                         SEQ(
                          MOVE(
                           TEMP(t79)
                           TEMP(t51))
                          SEQ(
                           CJUMP(EQ
                            TEMP(t78)
                            CONST(0)
                            _BADPTR L38)
                           SEQ(
                            LABEL(L38)
                            SEQ(
                             CJUMP(LT
                              TEMP(t79)
                              CONST(0)
                              _BADSUB L39)
                             SEQ(
                              LABEL(L39)
                              CJUMP(GE
                               TEMP(t79)
                               MEM(
                                BINOP(PLUS
                                 TEMP(t78)
                                 CONST(-4)))
                               _BADSUB L40)))))))
                        ESEQ(
                         LABEL(L40)
                         MEM(
                          BINOP(PLUS
                           TEMP(t78)
                           BINOP(MUL
                            TEMP(t79)
                            CONST(4))))))
                       TEMP(t53)))
                     MOVE(
                      TEMP(t52)
                      ESEQ(
                       SEQ(
                        MOVE(
                         TEMP(t80)
                         TEMP(t50))
                        SEQ(
                         CJUMP(EQ
                          TEMP(t80)
                          CONST(0)
                          _BADPTR L41)
                         LABEL(L41)))
                       CALL(
                        MEM(
                         BINOP(PLUS
                          MEM(
                           BINOP(PLUS
                            TEMP(t80)
                            CONST(-4)))
                          CONST(4)))
                        TEMP(t80)
                        BINOP(PLUS
                         TEMP(t51)
                         CONST(1))
                       ))))
                    MOVE(
                     ESEQ(
                      SEQ(
                       MOVE(
                        TEMP(t82)
                        ESEQ(
                         SEQ(
                          MOVE(
                           TEMP(t81)
                           TEMP(t50))
                          CJUMP(EQ
                           TEMP(t81)
                           CONST(0)
                           _BADPTR L42))
                         ESEQ(
                          LABEL(L42)
                          MEM(
                           BINOP(PLUS
                            TEMP(t81)
                            CONST(4))))))
                       SEQ(
                        MOVE(
                         TEMP(t83)
                         TEMP(t53))
                        SEQ(
                         CJUMP(EQ
                          TEMP(t82)
                          CONST(0)
                          _BADPTR L43)
                         SEQ(
                          LABEL(L43)
                          SEQ(
                           CJUMP(LT
                            TEMP(t83)
                            CONST(0)
                            _BADSUB L44)
                           SEQ(
                            LABEL(L44)
                            CJUMP(GE
                             TEMP(t83)
                             MEM(
                              BINOP(PLUS
                               TEMP(t82)
                               CONST(-4)))
                             _BADSUB L45)))))))
                      ESEQ(
                       LABEL(L45)
                       MEM(
                        BINOP(PLUS
                         TEMP(t82)
                         BINOP(MUL
                          TEMP(t83)
                          CONST(4))))))
                     CONST(0)))
                   MOVE(
                    ESEQ(
                     SEQ(
                      MOVE(
                       TEMP(t85)
                       ESEQ(
                        SEQ(
                         MOVE(
                          TEMP(t84)
                          TEMP(t50))
                         CJUMP(EQ
                          TEMP(t84)
                          CONST(0)
                          _BADPTR L46))
                        ESEQ(
                         LABEL(L46)
                         MEM(
                          BINOP(PLUS
                           TEMP(t84)
                           CONST(12))))))
                      SEQ(
                       MOVE(
                        TEMP(t86)
                        BINOP(PLUS
                         TEMP(t53)
                         TEMP(t51)))
                       SEQ(
                        CJUMP(EQ
                         TEMP(t85)
                         CONST(0)
                         _BADPTR L47)
                        SEQ(
                         LABEL(L47)
                         SEQ(
                          CJUMP(LT
                           TEMP(t86)
                           CONST(0)
                           _BADSUB L48)
                          SEQ(
                           LABEL(L48)
                           CJUMP(GE
                            TEMP(t86)
                            MEM(
                             BINOP(PLUS
                              TEMP(t85)
                              CONST(-4)))
                            _BADSUB L49)))))))
                     ESEQ(
                      LABEL(L49)
                      MEM(
                       BINOP(PLUS
                        TEMP(t85)
                        BINOP(MUL
                         TEMP(t86)
                         CONST(4))))))
                    CONST(0)))
                  MOVE(
                   ESEQ(
                    SEQ(
                     MOVE(
                      TEMP(t89)
                      ESEQ(
                       SEQ(
                        MOVE(
                         TEMP(t87)
                         TEMP(t50))
                        CJUMP(EQ
                         TEMP(t87)
                         CONST(0)
                         _BADPTR L50))
                       ESEQ(
                        LABEL(L50)
                        MEM(
                         BINOP(PLUS
                          TEMP(t87)
                          CONST(16))))))
                     SEQ(
                      MOVE(
                       TEMP(t90)
                       BINOP(MINUS
                        BINOP(MINUS
                         BINOP(PLUS
                          TEMP(t53)
                          ESEQ(
                           SEQ(
                            MOVE(
                             TEMP(t88)
                             TEMP(t50))
                            CJUMP(EQ
                             TEMP(t88)
                             CONST(0)
                             _BADPTR L51))
                           ESEQ(
                            LABEL(L51)
                            MEM(
                             BINOP(PLUS
                              TEMP(t88)
                              CONST(0))))))
                         CONST(1))
                        TEMP(t51)))
                      SEQ(
                       CJUMP(EQ
                        TEMP(t89)
                        CONST(0)
                        _BADPTR L52)
                       SEQ(
                        LABEL(L52)
                        SEQ(
                         CJUMP(LT
                          TEMP(t90)
                          CONST(0)
                          _BADSUB L53)
                         SEQ(
                          LABEL(L53)
                          CJUMP(GE
                           TEMP(t90)
                           MEM(
                            BINOP(PLUS
                             TEMP(t89)
                             CONST(-4)))
                           _BADSUB L54)))))))
                    ESEQ(
                     LABEL(L54)
                     MEM(
                      BINOP(PLUS
                       TEMP(t89)
                       BINOP(MUL
                        TEMP(t90)
                        CONST(4))))))
                   CONST(0))))
                JUMP(
                 NAME(L56))))
              LABEL(L56))
             MOVE(
              TEMP(t53)
              BINOP(PLUS
               TEMP(t53)
               CONST(1)))))
           JUMP(
            NAME(L60))))
         LABEL(L59))))
      JUMP(
       NAME(L64)))))
   LABEL(L64)))
 MOVE(
  TEMP(t2)
  CONST(0)))
)
DataFrag(
	.data
L71:	.asciiz	" Q"
)
DataFrag(
	.data
L72:	.asciiz	" ."
)
ProcFrag(
MipsFrame(
Queens2.printboard:
Formals(InReg(t91)
	)
Actuals(InReg(t4)
	)
BadPtr(_BADPTR)
BadSub(_BADSUB)
)
SEQ(
 SEQ(
  SEQ(
   SEQ(
    MOVE(
     TEMP(t92)
     CONST(0))
    MOVE(
     TEMP(t93)
     CONST(0)))
   SEQ(
    SEQ(
     SEQ(
      LABEL(L80)
      CJUMP(LT
       TEMP(t92)
       ESEQ(
        SEQ(
         MOVE(
          TEMP(t94)
          TEMP(t91))
         CJUMP(EQ
          TEMP(t94)
          CONST(0)
          _BADPTR L65))
        ESEQ(
         LABEL(L65)
         MEM(
          BINOP(PLUS
           TEMP(t94)
           CONST(0)))))
       L81 L79))
     SEQ(
      SEQ(
       LABEL(L81)
       SEQ(
        SEQ(
         SEQ(
          MOVE(
           TEMP(t93)
           CONST(0))
          SEQ(
           SEQ(
            SEQ(
             LABEL(L77)
             CJUMP(LT
              TEMP(t93)
              ESEQ(
               SEQ(
                MOVE(
                 TEMP(t95)
                 TEMP(t91))
                CJUMP(EQ
                 TEMP(t95)
                 CONST(0)
                 _BADPTR L66))
               ESEQ(
                LABEL(L66)
                MEM(
                 BINOP(PLUS
                  TEMP(t95)
                  CONST(0)))))
              L78 L76))
            SEQ(
             SEQ(
              LABEL(L78)
              SEQ(
               SEQ(
                SEQ(
                 CJUMP(EQ
                  ESEQ(
                   SEQ(
                    MOVE(
                     TEMP(t97)
                     ESEQ(
                      SEQ(
                       MOVE(
                        TEMP(t96)
                        TEMP(t91))
                       CJUMP(EQ
                        TEMP(t96)
                        CONST(0)
                        _BADPTR L67))
                      ESEQ(
                       LABEL(L67)
                       MEM(
                        BINOP(PLUS
                         TEMP(t96)
                         CONST(8))))))
                    SEQ(
                     MOVE(
                      TEMP(t98)
                      TEMP(t92))
                     SEQ(
                      CJUMP(EQ
                       TEMP(t97)
                       CONST(0)
                       _BADPTR L68)
                      SEQ(
                       LABEL(L68)
                       SEQ(
                        CJUMP(LT
                         TEMP(t98)
                         CONST(0)
                         _BADSUB L69)
                        SEQ(
                         LABEL(L69)
                         CJUMP(GE
                          TEMP(t98)
                          MEM(
                           BINOP(PLUS
                            TEMP(t97)
                            CONST(-4)))
                          _BADSUB L70)))))))
                   ESEQ(
                    LABEL(L70)
                    MEM(
                     BINOP(PLUS
                      TEMP(t97)
                      BINOP(MUL
                       TEMP(t98)
                       CONST(4))))))
                  TEMP(t93)
                  L73 L74)
                 SEQ(
                  SEQ(
                   SEQ(
                    LABEL(L73)
                    EXP(
                     CALL(
                      NAME(_print)
                      NAME(L71)
                     )))
                   JUMP(
                    NAME(L75)))
                  SEQ(
                   SEQ(
                    LABEL(L74)
                    EXP(
                     CALL(
                      NAME(_print)
                      NAME(L72)
                     )))
                   JUMP(
                    NAME(L75)))))
                LABEL(L75))
               MOVE(
                TEMP(t93)
                BINOP(PLUS
                 TEMP(t93)
                 CONST(1)))))
             JUMP(
              NAME(L77))))
           LABEL(L76)))
         EXP(
          CALL(
           NAME(_println)
          )))
        MOVE(
         TEMP(t92)
         BINOP(PLUS
          TEMP(t92)
          CONST(1)))))
      JUMP(
       NAME(L80))))
    LABEL(L79)))
  EXP(
   CALL(
    NAME(_println)
   )))
 MOVE(
  TEMP(t2)
  CONST(0)))
)
