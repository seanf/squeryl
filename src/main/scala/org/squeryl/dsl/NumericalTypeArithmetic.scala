package org.squeryl.dsl

import ast.{BinaryOperatorNode, ExpressionNode}

trait NumericalTypeArithmetic {

  type ByteType

  type IntType

  type StringType

  type FloatType

  type DoubleType

  type LongType


  class NumericalExpression[A] {

    def +[B](b: NumericalExpression[B]) = new BinaryAMSOp[A,B](this, b, "+")
    def *[B](b: NumericalExpression[B]) = new BinaryAMSOp[A,B](this, b, "*")
    def -[B](b: NumericalExpression[B]) = new BinaryAMSOp[A,B](this, b, "-")
    def /[B](b: NumericalExpression[B]) = new BinaryDivOp[A,B](this, b, "/")

    def ~ = this
  }
  
  class NumericalTypeConvertion[A](e: ExpressionNode) extends NumericalExpression[A]

  class BinaryAMSOp[A1,A2](a1: NumericalExpression[A1], a2: NumericalExpression[A2], op: String) extends BinaryOperatorNode(a1,a2, op)

  class BinaryDivOp[A1,A2](a1: NumericalExpression[A1], a2: NumericalExpression[A2], op: String) extends BinaryOperatorNode(a1,a2, op)

  class UnaryFloatOp[A](a: NumericalExpression[A], op: String) extends ExpressionNode

  class UnaryAgregateFloatOp[A](a: NumericalExpression[A], op: String) extends ExpressionNode

  class UnaryAgregateLengthNeutralOp[A](a: NumericalExpression[A], op: String) extends ExpressionNode



  // conversions for binary ops like Addition subtraction, multiplication :
  implicit def binaryOpConv1(op: BinaryAMSOp[ByteType,ByteType]) = new NumericalTypeConvertion[ByteType](op)
  implicit def binaryOpConv2(op: BinaryAMSOp[ByteType,IntType]) = new NumericalTypeConvertion[IntType](op)
  implicit def binaryOpConv3(op: BinaryAMSOp[ByteType,LongType]) = new NumericalTypeConvertion[LongType](op)
  implicit def binaryOpConv4(op: BinaryAMSOp[ByteType,FloatType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv5(op: BinaryAMSOp[ByteType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv6(op: BinaryAMSOp[ByteType,Option[ByteType]]) = new NumericalTypeConvertion[Option[ByteType]](op)
  implicit def binaryOpConv7(op: BinaryAMSOp[ByteType,Option[IntType]]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv8(op: BinaryAMSOp[ByteType,Option[LongType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv9(op: BinaryAMSOp[ByteType,Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv10(op: BinaryAMSOp[ByteType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv11(op: BinaryAMSOp[IntType,ByteType]) = new NumericalTypeConvertion[IntType](op)
  implicit def binaryOpConv12(op: BinaryAMSOp[IntType,IntType]) = new NumericalTypeConvertion[IntType](op)
  implicit def binaryOpConv13(op: BinaryAMSOp[IntType,LongType]) = new NumericalTypeConvertion[LongType](op)
  implicit def binaryOpConv14(op: BinaryAMSOp[IntType,FloatType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv15(op: BinaryAMSOp[IntType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv16(op: BinaryAMSOp[IntType,Option[ByteType]]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv17(op: BinaryAMSOp[IntType,Option[IntType]]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv18(op: BinaryAMSOp[IntType,Option[LongType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv19(op: BinaryAMSOp[IntType,Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv20(op: BinaryAMSOp[IntType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv21(op: BinaryAMSOp[LongType,ByteType]) = new NumericalTypeConvertion[LongType](op)
  implicit def binaryOpConv22(op: BinaryAMSOp[LongType,IntType]) = new NumericalTypeConvertion[LongType](op)
  implicit def binaryOpConv23(op: BinaryAMSOp[LongType,LongType]) = new NumericalTypeConvertion[LongType](op)
  implicit def binaryOpConv24(op: BinaryAMSOp[LongType,FloatType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv25(op: BinaryAMSOp[LongType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv26(op: BinaryAMSOp[LongType,Option[ByteType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv27(op: BinaryAMSOp[LongType,Option[IntType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv28(op: BinaryAMSOp[LongType,Option[LongType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv29(op: BinaryAMSOp[LongType,Option[FloatType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv30(op: BinaryAMSOp[LongType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv31(op: BinaryAMSOp[FloatType,ByteType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv32(op: BinaryAMSOp[FloatType,IntType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv33(op: BinaryAMSOp[FloatType,LongType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv34(op: BinaryAMSOp[FloatType,FloatType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv35(op: BinaryAMSOp[FloatType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv36(op: BinaryAMSOp[FloatType,Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv37(op: BinaryAMSOp[FloatType,Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv38(op: BinaryAMSOp[FloatType,Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv39(op: BinaryAMSOp[FloatType,Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv40(op: BinaryAMSOp[FloatType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv41(op: BinaryAMSOp[DoubleType,ByteType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv42(op: BinaryAMSOp[DoubleType,IntType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv43(op: BinaryAMSOp[DoubleType,LongType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv44(op: BinaryAMSOp[DoubleType,FloatType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv45(op: BinaryAMSOp[DoubleType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv46(op: BinaryAMSOp[DoubleType,Option[ByteType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv47(op: BinaryAMSOp[DoubleType,Option[IntType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv48(op: BinaryAMSOp[DoubleType,Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv49(op: BinaryAMSOp[DoubleType,Option[FloatType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv50(op: BinaryAMSOp[DoubleType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv51(op: BinaryAMSOp[Option[ByteType],ByteType]) = new NumericalTypeConvertion[Option[ByteType]](op)
  implicit def binaryOpConv52(op: BinaryAMSOp[Option[ByteType],IntType]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv53(op: BinaryAMSOp[Option[ByteType],LongType]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv54(op: BinaryAMSOp[Option[ByteType],FloatType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv55(op: BinaryAMSOp[Option[ByteType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv56(op: BinaryAMSOp[Option[ByteType],Option[ByteType]]) = new NumericalTypeConvertion[Option[ByteType]](op)
  implicit def binaryOpConv57(op: BinaryAMSOp[Option[ByteType],Option[IntType]]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv58(op: BinaryAMSOp[Option[ByteType],Option[LongType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv59(op: BinaryAMSOp[Option[ByteType],Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv60(op: BinaryAMSOp[Option[ByteType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv61(op: BinaryAMSOp[Option[IntType],ByteType]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv62(op: BinaryAMSOp[Option[IntType],IntType]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv63(op: BinaryAMSOp[Option[IntType],LongType]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv64(op: BinaryAMSOp[Option[IntType],FloatType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv65(op: BinaryAMSOp[Option[IntType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv66(op: BinaryAMSOp[Option[IntType],Option[ByteType]]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv67(op: BinaryAMSOp[Option[IntType],Option[IntType]]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def binaryOpConv68(op: BinaryAMSOp[Option[IntType],Option[LongType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv69(op: BinaryAMSOp[Option[IntType],Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv70(op: BinaryAMSOp[Option[IntType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv71(op: BinaryAMSOp[Option[LongType],ByteType]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv72(op: BinaryAMSOp[Option[LongType],IntType]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv73(op: BinaryAMSOp[Option[LongType],LongType]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv74(op: BinaryAMSOp[Option[LongType],FloatType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv75(op: BinaryAMSOp[Option[LongType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv76(op: BinaryAMSOp[Option[LongType],Option[ByteType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv77(op: BinaryAMSOp[Option[LongType],Option[IntType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv78(op: BinaryAMSOp[Option[LongType],Option[LongType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def binaryOpConv79(op: BinaryAMSOp[Option[LongType],Option[FloatType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv80(op: BinaryAMSOp[Option[LongType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv81(op: BinaryAMSOp[Option[FloatType],ByteType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv82(op: BinaryAMSOp[Option[FloatType],IntType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv83(op: BinaryAMSOp[Option[FloatType],LongType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv84(op: BinaryAMSOp[Option[FloatType],FloatType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv85(op: BinaryAMSOp[Option[FloatType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv86(op: BinaryAMSOp[Option[FloatType],Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv87(op: BinaryAMSOp[Option[FloatType],Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv88(op: BinaryAMSOp[Option[FloatType],Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv89(op: BinaryAMSOp[Option[FloatType],Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv90(op: BinaryAMSOp[Option[FloatType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv91(op: BinaryAMSOp[Option[DoubleType],ByteType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv92(op: BinaryAMSOp[Option[DoubleType],IntType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv93(op: BinaryAMSOp[Option[DoubleType],LongType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv94(op: BinaryAMSOp[Option[DoubleType],FloatType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv95(op: BinaryAMSOp[Option[DoubleType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv96(op: BinaryAMSOp[Option[DoubleType],Option[ByteType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv97(op: BinaryAMSOp[Option[DoubleType],Option[IntType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv98(op: BinaryAMSOp[Option[DoubleType],Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv99(op: BinaryAMSOp[Option[DoubleType],Option[FloatType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv100(op: BinaryAMSOp[Option[DoubleType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  // conversions for binary ops like Division :
  implicit def binaryOpConv1(op: BinaryDivOp[ByteType,ByteType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv2(op: BinaryDivOp[ByteType,IntType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv3(op: BinaryDivOp[ByteType,LongType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv4(op: BinaryDivOp[ByteType,FloatType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv5(op: BinaryDivOp[ByteType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv6(op: BinaryDivOp[ByteType,Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv7(op: BinaryDivOp[ByteType,Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv8(op: BinaryDivOp[ByteType,Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv9(op: BinaryDivOp[ByteType,Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv10(op: BinaryDivOp[ByteType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv11(op: BinaryDivOp[IntType,ByteType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv12(op: BinaryDivOp[IntType,IntType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv13(op: BinaryDivOp[IntType,LongType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv14(op: BinaryDivOp[IntType,FloatType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv15(op: BinaryDivOp[IntType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv16(op: BinaryDivOp[IntType,Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv17(op: BinaryDivOp[IntType,Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv18(op: BinaryDivOp[IntType,Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv19(op: BinaryDivOp[IntType,Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv20(op: BinaryDivOp[IntType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv21(op: BinaryDivOp[LongType,ByteType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv22(op: BinaryDivOp[LongType,IntType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv23(op: BinaryDivOp[LongType,LongType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv24(op: BinaryDivOp[LongType,FloatType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv25(op: BinaryDivOp[LongType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv26(op: BinaryDivOp[LongType,Option[ByteType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv27(op: BinaryDivOp[LongType,Option[IntType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv28(op: BinaryDivOp[LongType,Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv29(op: BinaryDivOp[LongType,Option[FloatType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv30(op: BinaryDivOp[LongType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv31(op: BinaryDivOp[FloatType,ByteType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv32(op: BinaryDivOp[FloatType,IntType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv33(op: BinaryDivOp[FloatType,LongType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv34(op: BinaryDivOp[FloatType,FloatType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def binaryOpConv35(op: BinaryDivOp[FloatType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv36(op: BinaryDivOp[FloatType,Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv37(op: BinaryDivOp[FloatType,Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv38(op: BinaryDivOp[FloatType,Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv39(op: BinaryDivOp[FloatType,Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv40(op: BinaryDivOp[FloatType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv41(op: BinaryDivOp[DoubleType,ByteType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv42(op: BinaryDivOp[DoubleType,IntType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv43(op: BinaryDivOp[DoubleType,LongType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv44(op: BinaryDivOp[DoubleType,FloatType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv45(op: BinaryDivOp[DoubleType,DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def binaryOpConv46(op: BinaryDivOp[DoubleType,Option[ByteType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv47(op: BinaryDivOp[DoubleType,Option[IntType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv48(op: BinaryDivOp[DoubleType,Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv49(op: BinaryDivOp[DoubleType,Option[FloatType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv50(op: BinaryDivOp[DoubleType,Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv51(op: BinaryDivOp[Option[ByteType],ByteType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv52(op: BinaryDivOp[Option[ByteType],IntType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv53(op: BinaryDivOp[Option[ByteType],LongType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv54(op: BinaryDivOp[Option[ByteType],FloatType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv55(op: BinaryDivOp[Option[ByteType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv56(op: BinaryDivOp[Option[ByteType],Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv57(op: BinaryDivOp[Option[ByteType],Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv58(op: BinaryDivOp[Option[ByteType],Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv59(op: BinaryDivOp[Option[ByteType],Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv60(op: BinaryDivOp[Option[ByteType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv61(op: BinaryDivOp[Option[IntType],ByteType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv62(op: BinaryDivOp[Option[IntType],IntType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv63(op: BinaryDivOp[Option[IntType],LongType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv64(op: BinaryDivOp[Option[IntType],FloatType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv65(op: BinaryDivOp[Option[IntType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv66(op: BinaryDivOp[Option[IntType],Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv67(op: BinaryDivOp[Option[IntType],Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv68(op: BinaryDivOp[Option[IntType],Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv69(op: BinaryDivOp[Option[IntType],Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv70(op: BinaryDivOp[Option[IntType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv71(op: BinaryDivOp[Option[LongType],ByteType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv72(op: BinaryDivOp[Option[LongType],IntType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv73(op: BinaryDivOp[Option[LongType],LongType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv74(op: BinaryDivOp[Option[LongType],FloatType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv75(op: BinaryDivOp[Option[LongType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv76(op: BinaryDivOp[Option[LongType],Option[ByteType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv77(op: BinaryDivOp[Option[LongType],Option[IntType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv78(op: BinaryDivOp[Option[LongType],Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv79(op: BinaryDivOp[Option[LongType],Option[FloatType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv80(op: BinaryDivOp[Option[LongType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv81(op: BinaryDivOp[Option[FloatType],ByteType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv82(op: BinaryDivOp[Option[FloatType],IntType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv83(op: BinaryDivOp[Option[FloatType],LongType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv84(op: BinaryDivOp[Option[FloatType],FloatType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv85(op: BinaryDivOp[Option[FloatType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv86(op: BinaryDivOp[Option[FloatType],Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv87(op: BinaryDivOp[Option[FloatType],Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv88(op: BinaryDivOp[Option[FloatType],Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv89(op: BinaryDivOp[Option[FloatType],Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def binaryOpConv90(op: BinaryDivOp[Option[FloatType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv91(op: BinaryDivOp[Option[DoubleType],ByteType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv92(op: BinaryDivOp[Option[DoubleType],IntType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv93(op: BinaryDivOp[Option[DoubleType],LongType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv94(op: BinaryDivOp[Option[DoubleType],FloatType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv95(op: BinaryDivOp[Option[DoubleType],DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv96(op: BinaryDivOp[Option[DoubleType],Option[ByteType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv97(op: BinaryDivOp[Option[DoubleType],Option[IntType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv98(op: BinaryDivOp[Option[DoubleType],Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv99(op: BinaryDivOp[Option[DoubleType],Option[FloatType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def binaryOpConv100(op: BinaryDivOp[Option[DoubleType],Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  // conversions for unary ops like Sin, Log(n,X) :
  implicit def unaryOpConv1(op: UnaryFloatOp[ByteType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def unaryOpConv2(op: UnaryFloatOp[IntType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def unaryOpConv3(op: UnaryFloatOp[LongType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def unaryOpConv4(op: UnaryFloatOp[FloatType]) = new NumericalTypeConvertion[FloatType](op)
  implicit def unaryOpConv5(op: UnaryFloatOp[DoubleType]) = new NumericalTypeConvertion[DoubleType](op)
  implicit def unaryOpConv6(op: UnaryFloatOp[Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv7(op: UnaryFloatOp[Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv8(op: UnaryFloatOp[Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def unaryOpConv9(op: UnaryFloatOp[Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv10(op: UnaryFloatOp[Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  // conversions for unary ops like Avg, Stdev :
  implicit def unaryOpConv1(op: UnaryAgregateFloatOp[ByteType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv2(op: UnaryAgregateFloatOp[IntType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv3(op: UnaryAgregateFloatOp[LongType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def unaryOpConv4(op: UnaryAgregateFloatOp[FloatType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv5(op: UnaryAgregateFloatOp[DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def unaryOpConv6(op: UnaryAgregateFloatOp[Option[ByteType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv7(op: UnaryAgregateFloatOp[Option[IntType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv8(op: UnaryAgregateFloatOp[Option[LongType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def unaryOpConv9(op: UnaryAgregateFloatOp[Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv10(op: UnaryAgregateFloatOp[Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  // conversions for unary ops like Min, Max :
  implicit def unaryOpConv1(op: UnaryAgregateLengthNeutralOp[ByteType]) = new NumericalTypeConvertion[Option[ByteType]](op)
  implicit def unaryOpConv2(op: UnaryAgregateLengthNeutralOp[IntType]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def unaryOpConv3(op: UnaryAgregateLengthNeutralOp[LongType]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def unaryOpConv4(op: UnaryAgregateLengthNeutralOp[FloatType]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv5(op: UnaryAgregateLengthNeutralOp[DoubleType]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  implicit def unaryOpConv6(op: UnaryAgregateLengthNeutralOp[Option[ByteType]]) = new NumericalTypeConvertion[Option[ByteType]](op)
  implicit def unaryOpConv7(op: UnaryAgregateLengthNeutralOp[Option[IntType]]) = new NumericalTypeConvertion[Option[IntType]](op)
  implicit def unaryOpConv8(op: UnaryAgregateLengthNeutralOp[Option[LongType]]) = new NumericalTypeConvertion[Option[LongType]](op)
  implicit def unaryOpConv9(op: UnaryAgregateLengthNeutralOp[Option[FloatType]]) = new NumericalTypeConvertion[Option[FloatType]](op)
  implicit def unaryOpConv10(op: UnaryAgregateLengthNeutralOp[Option[DoubleType]]) = new NumericalTypeConvertion[Option[DoubleType]](op)
  
}