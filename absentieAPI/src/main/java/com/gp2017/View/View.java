package com.gp2017.View;

public interface View {
     interface LesGetByIdView extends LesView.Full, DocentView.Minimal, AbsentieView.Minimal, StudentView.Minimal {
     }
     interface StudentGetByIdView extends StudentView.Full, PersoonView.Minimal, AbsentieView.Minimal, LesView.Minimal {
     }
}

