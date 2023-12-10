/*
    Copyright (C) 2017 Red Hat, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
import { IConstant, IDocumentName, INamespace, IProperty } from '../UI';
import { IParameter, getCsvParameterOptions } from '@atlasmap/core';
import React, { useCallback, useMemo, useState } from 'react';
import {
  enableCustomClass,
  getDocCSVParams,
  getPropertyScopeOptions,
  setDocCSVParams,
} from './utils';
import {
  useAboutDialog,
  useCaptureDocumentIDToast,
  useChangeDocumentNameDialog,
  useConstantDialog,
  useCustomClassDialog,
  useDeleteConstantDialog,
  useDeleteDocumentDialog,
  useDeleteMappingDialog,
  useDeletePropertyDialog,
  useEditMappingEnumerationDialog,
  useExportADMArchiveDialog,
  useImportADMArchiveDialog,
  useImportDocumentDialog,
  useNamespaceDialog,
  useParametersDialog,
  usePropertyDialog,
  useRemoveMappedFieldDialog,
  useResetAtlasmapDialog,
  useSpecifyInstanceSchemaDialog,
  useToggleExpressionModeDialog,
} from './dialogs';

import { IAtlasmapDocument } from '../Views';
import { createPortal } from 'react-dom';
import { useAtlasmap } from './AtlasmapProvider';

export interface IUseAtlasmapDialogsProps {
  modalContainer: HTMLElement;
}
export function useAtlasmapDialogs({
  modalContainer,
}: IUseAtlasmapDialogsProps) {
  const {
    configModel,
    selectedMapping,
    createConstant,
    editConstant,
    createProperty,
    editProperty,
    createNamespace,
    editNamespace,
    deleteNamespace,
    changeDocumentName,
  } = useAtlasmap();

  //#region constant dialogs
  const [createConstantDialog, openCreateConstantDialog] =
    useConstantDialog('Create Constant');
  const onCreateConstant = useCallback(
    (constants: IAtlasmapDocument | null, addToActiveMapping?: boolean) => {
      openCreateConstantDialog(({ name, value, valueType }) => {
        createConstant(name, value, valueType, addToActiveMapping);
      }, constants);
    },
    [createConstant, openCreateConstantDialog],
  );
  const [editConstantDialog, openEditConstantDialog] =
    useConstantDialog('Edit Constant');
  const onEditConstant = useCallback(
    (constant: IConstant, constants: IAtlasmapDocument | null) => {
      openEditConstantDialog(
        ({ name, value, valueType }, origName) => {
          editConstant(name, value, valueType, origName);
        },
        constants,
        constant,
      );
    },
    [editConstant, openEditConstantDialog],
  );
  const [deleteConstantDialog, onDeleteConstant] = useDeleteConstantDialog();
  //#endregion

  //#region property dialogs
  const [scopeOptions, setScopeOptions] = useState(
    getPropertyScopeOptions(true),
  );
  const [createPropertyDialog, openCreatePropertyDialog] = usePropertyDialog(
    'Create Property',
    scopeOptions,
  );
  const onCreateProperty = useCallback(
    (
      isSource: boolean,
      properties: IAtlasmapDocument | null,
      addToActiveMapping?: boolean,
    ) => {
      setScopeOptions(getPropertyScopeOptions(isSource));
      openCreatePropertyDialog(({ name, valueType, scope }) => {
        createProperty(name, valueType, scope, isSource, addToActiveMapping);
      }, properties);
    },
    [createProperty, openCreatePropertyDialog],
  );
  const [editPropertyDialog, openEditPropertyDialog] = usePropertyDialog(
    'Edit Property',
    scopeOptions,
  );
  const onEditProperty = useCallback(
    (
      property: IProperty,
      isSource: boolean,
      properties: IAtlasmapDocument | null,
    ) => {
      setScopeOptions(getPropertyScopeOptions(isSource));
      openEditPropertyDialog(
        ({ name, valueType, scope }) => {
          editProperty(
            property.name,
            valueType,
            property.scope,
            isSource,
            name,
            scope,
          );
        },
        properties,
        property,
      );
    },
    [editProperty, openEditPropertyDialog],
  );
  const [deletePropertyDialog, onDeleteProperty] = useDeletePropertyDialog();
  //#endregion

  //#region atlasmap catalog
  const [importADMArchiveDialog, onImportADMArchive] =
    useImportADMArchiveDialog();
  const [exportADMArchiveDialog, onExportADMArchive] =
    useExportADMArchiveDialog();
  const [resetDialog, onResetAtlasmap] = useResetAtlasmapDialog();
  const [aboutDialog, onAbout] = useAboutDialog();
  const [toggleExpressionModeDialog, onToggleExpressionMode] =
    useToggleExpressionModeDialog();
  //#endregion

  //#region document dialogs
  const [importDocumentDialog, onImportDocument] = useImportDocumentDialog();
  const [deleteDocumentDialog, onDeleteDocument] = useDeleteDocumentDialog();
  const [captureDocumentNameToast, onCaptureDocumentID] =
    useCaptureDocumentIDToast();

  const [changeDocumentNameDialog, openChangeDocumentNameDialog] =
    useChangeDocumentNameDialog();
  const onChangeDocumentName = useCallback(
    (docNameInfo: IDocumentName) => {
      openChangeDocumentNameDialog(({ id, name, isSource }) => {
        changeDocumentName(id, name, isSource);
      }, docNameInfo);
    },
    [changeDocumentName, openChangeDocumentNameDialog],
  );
  //#endregion

  const myTesting=(s:any)=>{
    console.log("222",s)
      console.log("rajkumarss",configModel.getAllDocs())
    const testing:any={
      "exportMappings":{"value":"\"{\\\"AtlasMapping\\\":{\\\"jsonType\\\":\\\"io.atlasmap.v2.AtlasMapping\\\",\\\"dataSource\\\":[{\\\"jsonType\\\":\\\"io.atlasmap.xml.v2.XmlDataSource\\\",\\\"id\\\":\\\"equifax_requestMin-9e507bd2-d09b-4e46-9d49-1ac79a03784c\\\",\\\"name\\\":\\\"equifax_requestMin\\\",\\\"description\\\":\\\"Source document equifax_requestMin type: XML\\\",\\\"uri\\\":\\\"atlas:xml:equifax_requestMin-9e507bd2-d09b-4e46-9d49-1ac79a03784c\\\",\\\"dataSourceType\\\":\\\"SOURCE\\\",\\\"xmlNamespaces\\\":{\\\"xmlNamespace\\\":[{\\\"uri\\\":\\\"http://xml.equifax.com/XMLSchema\\\"}]}}],\\\"mappings\\\":{\\\"mapping\\\":[]},\\\"lookupTables\\\":{\\\"lookupTable\\\":[]},\\\"constants\\\":{\\\"constant\\\":[{\\\"name\\\":\\\"css\\\",\\\"value\\\":\\\"cds\\\",\\\"fieldType\\\":\\\"STRING\\\"},{\\\"name\\\":\\\"das\\\",\\\"value\\\":\\\"sacd\\\",\\\"fieldType\\\":\\\"DATE_TZ\\\"},{\\\"name\\\":\\\"wefef\\\",\\\"value\\\":\\\"fwdw\\\",\\\"fieldType\\\":\\\"STRING\\\"}]},\\\"properties\\\":{\\\"property\\\":[]},\\\"name\\\":\\\"UI.0\\\",\\\"version\\\":\\\"2.6.0-SNAPSHOT\\\"}}\""},
    "exportMeta":[{"name":"equifax_requestMin","dataSourceType":"XML","id":"equifax_requestMin-9e507bd2-d09b-4e46-9d49-1ac79a03784c","inspectionType":"INSTANCE","inspectionParameters":{"":""},"isSource":true}],
    "exportBlockData":[{"value":"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n<EfxReceive customerNumber=\"484IG00144\" securityCode=\"U86\" tranID=\"XDIA\" version=\"6.0\" xmlns=\"http://xml.equifax.com/XMLSchema\">\r\n\t<CustomerInfo id=\"abc\">\r\n\t\t<CustomerNumber id=\"123\">484IG00144</CustomerNumber>\r\n\t\t<SecurityCode id=\"234\">U86</SecurityCode>\r\n\t\t<Raj id=\"123\">kkk</Raj>\r\n\t\t<MultipleFileIndicator>1</MultipleFileIndicator>\r\n\t</CustomerInfo>\r\n</EfxReceive>"}]
}
      configModel.fileService.setMappingDigestToService(testing)
  }
  //#region namespace table dialogs
  const [createNamespaceDialog, openCreateNamespaceDialog] =
    useNamespaceDialog('Create namespace');
  const onCreateNamespace = useCallback(
    (docName: string) => {
      openCreateNamespaceDialog(
        ({ alias, uri, locationUri, targetNamespace }) =>
          createNamespace(docName, alias, uri, locationUri, targetNamespace),
      );
    },
    [createNamespace, openCreateNamespaceDialog],
  );
  const [editNamespaceDialog, openEditNamespaceDialog] =
    useNamespaceDialog('Edit namespace');
  const onEditNamespace = useCallback(
    (docName: string, namespace: INamespace) => {
      openEditNamespaceDialog(
        ({ alias, uri, locationUri, targetNamespace }) =>
          editNamespace(
            docName,
            namespace.alias,
            alias,
            uri,
            locationUri,
            targetNamespace,
          ),
        namespace,
      );
    },
    [editNamespace, openEditNamespaceDialog],
  );
  //#endregion

  //#region mapping support dialogs
  const [removeMappedFieldDialog, onRemoveMappedField] =
    useRemoveMappedFieldDialog();
  const [deleteMappingDialog, onDeleteMapping] = useDeleteMappingDialog();
  const onDeleteSelectedMapping = useCallback(() => {
    if (selectedMapping) {
      onDeleteMapping(selectedMapping);
    }
  }, [onDeleteMapping, selectedMapping]);
  const [editMappingEnumerationDialog, onEditMappingEnumeration] =
    useEditMappingEnumerationDialog();
  //#endregion

  //#region custom class dialogs
  const [createEnableCustomClassDialog, openCreateEnableCustomClassDialog] =
    useCustomClassDialog('Load Java Document From Custom Class');
  const onEnableCustomClass = useCallback(
    (isSource: boolean): void => {
      openCreateEnableCustomClassDialog(({ customClassName, collectionType }) =>
        enableCustomClass(
          configModel,
          customClassName,
          collectionType,
          isSource,
        ),
      );
    },
    [configModel, openCreateEnableCustomClassDialog],
  );
  //#endregion

  //#region CSV processing dialogs
  const [editCSVParamsDialog, openEditCSVParamsDialog] = useParametersDialog(
    'Edit CSV Processing Parameters',
  );
  function initialCSVParams(docId: string, isSource: boolean): IParameter[] {
    // User-defined CSV parameters.
    const predefinedParameters: { [key: string]: string } = getDocCSVParams(
      docId,
      isSource,
    );

    // Complete list of available CSV parameters.
    const initialCSVParameters = getCsvParameterOptions();
    const predefinedParamNames = Object.keys(predefinedParameters).map(
      (key) => key,
    );
    const predefinedParamValues = Object.values(predefinedParameters).map(
      (key) => key,
    );

    // Annotate the initial CSV parameters with the predefined values.
    for (const { index } of initialCSVParameters.map((value, index) => ({
      index,
      value,
    }))) {
      for (const { pvalue, pindex } of predefinedParamNames.map(
        (pvalue, pindex) => ({
          pindex,
          pvalue,
        }),
      )) {
        if (initialCSVParameters[index].name === pvalue) {
          initialCSVParameters[index].value = predefinedParamValues[pindex];
          initialCSVParameters[index].enabled = true;
          break;
        }
      }
    }
    return initialCSVParameters;
  }
  const onEditCSVParams = useCallback(
    (docId: string, isSource: boolean) => {
      openEditCSVParamsDialog((parameters) => {
        const inspectionParameters: { [key: string]: string } = {};
        for (let parameter of parameters) {
          inspectionParameters[parameter.name] = parameter.value;
        }
        setDocCSVParams(docId, isSource, inspectionParameters);
      }, initialCSVParams(docId, isSource));
    },
    [openEditCSVParamsDialog],
  );
  //#endregion

  const [specifyInstanceSchemaDialog, onSpecifyInstanceSchema] =
    useSpecifyInstanceSchemaDialog(false);

  const portal = useMemo(
    () =>
      createPortal(
        <>
          {importADMArchiveDialog}
          {exportADMArchiveDialog}
          {importDocumentDialog}
          {deleteDocumentDialog}
          {specifyInstanceSchemaDialog}
          {captureDocumentNameToast}
          {changeDocumentNameDialog}
          {createConstantDialog}
          {deleteConstantDialog}
          {editConstantDialog}
          {createPropertyDialog}
          {deletePropertyDialog}
          {editPropertyDialog}
          {resetDialog}
          {aboutDialog}
          {removeMappedFieldDialog}
          {deleteMappingDialog}
          {createEnableCustomClassDialog}
          {createNamespaceDialog}
          {editNamespaceDialog}
          {toggleExpressionModeDialog}
          {editMappingEnumerationDialog}
          {editCSVParamsDialog}
        </>,
        modalContainer,
      ),
    [
      createConstantDialog,
      createEnableCustomClassDialog,
      createNamespaceDialog,
      createPropertyDialog,
      deleteConstantDialog,
      deleteDocumentDialog,
      captureDocumentNameToast,
      changeDocumentNameDialog,
      deleteMappingDialog,
      deletePropertyDialog,
      editConstantDialog,
      editNamespaceDialog,
      editPropertyDialog,
      exportADMArchiveDialog,
      importADMArchiveDialog,
      importDocumentDialog,
      specifyInstanceSchemaDialog,
      modalContainer,
      removeMappedFieldDialog,
      resetDialog,
      aboutDialog,
      toggleExpressionModeDialog,
      editMappingEnumerationDialog,
      editCSVParamsDialog,
    ],
  );

  return {
    handlers: {
      onImportADMArchive: onImportADMArchive,
      onExportADMArchive: onExportADMArchive,
      onCreateConstant,
      onDeleteConstant,
      onEditConstant,
      onCreateProperty,
      onDeleteProperty,
      onEditProperty,
      onResetAtlasmap,
      onAbout,
      onImportDocument,
      onDeleteDocument,
      onSpecifyInstanceSchema,
      onCaptureDocumentID,
      onChangeDocumentName,
      onRemoveMappedField,
      onDeleteMapping,
      onDeleteSelectedMapping,
      onEnableCustomClass,
      onCreateNamespace,
      onEditNamespace,
      deleteNamespace,
      onToggleExpressionMode,
      onEditMappingEnumeration,
      onEditCSVParams,
      myTesting
    },
    dialogs: portal,
  };
}
