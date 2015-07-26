;NSIS Modern User Interface version 1.70
;Dts2Manage Installer Script
;Written by Stephen Strenn

;--------------------------------
;Include Modern UI

  !include "MUI.nsh"

;--------------------------------
;General

  ;Name and file
  Name "Dts2Manage"
  OutFile "�ޱ���II �������� Installer.exe"

  ;Default installation folder
  InstallDir "$PROGRAMFILES\casmall\Dts2Manage"
  
  ;Get installation folder from registry if available
  InstallDirRegKey HKCU "Software\Dts2Manage" ""

;--------------------------------
;Interface Settings

  !define MUI_ABORTWARNING
	!define MUI_HEADERIMAGE ".\Dts2ManageInstallerSplash.bmp"
	!define MUI_HEADERIMAGE_BITMAP_NOSTRETCH
	!define MUI_HEADERIMAGE_BITMAP ".\Dts2ManageInstallerSplash.bmp"
	!define MUI_ICON ".\setup.ico"
	!define MUI_UNICON ".\setup.ico"

;--------------------------------
;Pages

  !insertmacro MUI_PAGE_LICENSE ".\License.txt"
  !insertmacro MUI_PAGE_COMPONENTS
  !insertmacro MUI_PAGE_DIRECTORY
  !insertmacro MUI_PAGE_INSTFILES
  
  !insertmacro MUI_UNPAGE_CONFIRM
  !insertmacro MUI_UNPAGE_INSTFILES
  
;--------------------------------
;Languages
 
  !insertmacro MUI_LANGUAGE "English"

;--------------------------------
;Installer Sections

Section "Dts2Manage (required)" SecDummy

  SectionIn RO

  ;Files to be installed
  SetOutPath "$INSTDIR"
  File ".\Dts2Manage.ico"
	File /r ".\Dts2Manage\"
	File /r ".\copy\"

    ; Write the installation path into the registry
  WriteRegStr HKLM SOFTWARE\Dts2Manage "Install_Dir" "$INSTDIR"
  
  ; Write the uninstall keys for Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Dts2Manage" "DisplayName" "Dts2Manage"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Dts2Manage" "UninstallString" '"$INSTDIR\uninstall.exe"'
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Dts2Manage" "NoModify" 1
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Dts2Manage" "NoRepair" 1
  WriteUninstaller "uninstall.exe"
  
SectionEnd

; Optional section (can be disabled by the user)
Section "Start Menu Shortcuts"
  SetShellVarContext all
  CreateDirectory "$SMPROGRAMS\�ޱ���2\��������"
  CreateShortCut "$SMPROGRAMS\�ޱ���2\��������\Uninstall.lnk" "$INSTDIR\uninstall.exe" "" "$INSTDIR\uninstall.exe"
  CreateShortCut "$SMPROGRAMS\�ޱ���2\��������\�ޱ���2 ��������.lnk" "$INSTDIR\Dts2Manage.exe" "" "$INSTDIR\Dts2Manage.ico"
SectionEnd

;--------------------------------
;Uninstaller Section

Section "Uninstall"
  
  ; Remove registry keys
  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Dts2Manage"
  DeleteRegKey HKLM SOFTWARE\Dts2Manage
  DeleteRegKey /ifempty HKCU "Software\Dts2Manage"

	; Remove shortcuts
	 SetShellVarContext all
	 ;Delete "$SMPROGRAMS\�ޱ���2\��������\*.*"
   RMDir /r "$SMPROGRAMS\�ޱ���2\��������"

  ; Remove directories used
  RMDir /r "$INSTDIR"

SectionEnd