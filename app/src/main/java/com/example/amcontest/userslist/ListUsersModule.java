package com.example.amcontest.userslist;

import com.example.amcontest.dependencyInjection.scoped.FragmentScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ListUsersModule {

    @FragmentScoped
    @ContributesAndroidInjector()
    abstract ListUsersFragment listUsersFragment();

    @FragmentScoped
    @ContributesAndroidInjector()
    abstract ContentUsersFragment contentUsersFragment();
}
