package com.example.amcontest.dependencyInjection;

import com.example.amcontest.MainActivity;
import com.example.amcontest.dependencyInjection.scoped.ActivityScoped;
import com.example.amcontest.userslist.ListUsersActivity;
import com.example.amcontest.userslist.ListUsersModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = ListUsersModule.class)
    abstract ListUsersActivity listUsersActivity();


}
